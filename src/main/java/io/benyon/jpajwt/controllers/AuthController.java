package io.benyon.jpajwt.controllers;

import io.benyon.jpajwt.jwt.JwtUtils;
import io.benyon.jpajwt.models.ERole;
import io.benyon.jpajwt.models.Role;
import io.benyon.jpajwt.models.User;
import io.benyon.jpajwt.payloads.request.LoginRequest;
import io.benyon.jpajwt.payloads.request.SignupRequest;
import io.benyon.jpajwt.payloads.response.JwtResponse;
import io.benyon.jpajwt.payloads.response.MessageResponse;
import io.benyon.jpajwt.repositories.UserRepository;
import io.benyon.jpajwt.repositories.RoleRepository;
import io.benyon.jpajwt.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;
  
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  RoleRepository roleRepository;
  
  @Autowired
  PasswordEncoder encoder;
  
  @Autowired
  JwtUtils jwtUtils;
  
  @PostMapping("/sign-in")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
      .map(item -> item.getAuthority())
      .collect(Collectors.toList());
    
    return ResponseEntity.ok(new JwtResponse(
      jwt,
      userDetails.getId(),
      userDetails.getUsername(),
      userDetails.getEmail(),
      roles
    ));
  }
  
  @RequestMapping("/sign-up")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
    if(userRepository.existsByUsername(signupRequest.getUsername())){
      return ResponseEntity.badRequest().body(new MessageResponse("Error: username already exist"));
    }
    if (userRepository.existsByEmail(signupRequest.getEmail())){
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use"));
    }
    // Let's create the account now
    User user = new User(
      signupRequest.getUsername(),
      signupRequest.getEmail(),
      encoder.encode(signupRequest.getPassword())
    );
    Set<String> strRoles = signupRequest.getRole();
    Set<Role> roles = new HashSet<>();
    
    if(strRoles == null){
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
        .orElseThrow(()-> new RuntimeException("Error: Role is not found"));
      roles.add(userRole);
    }else{
      strRoles.forEach(role -> {
        switch (role){
          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(()->new RuntimeException("Error: role is not found"));
            roles.add(adminRole);
            break;
          case "mod":
            Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(()-> new RuntimeException("Error: role not found"));
            roles.add(modRole);
            
          default:
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(()-> new RuntimeException("Error: Role not found"));
            roles.add(userRole);
        }
      });
    }
    user.setRoles(roles);
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse("User registered successfully"));
  }
}
