package io.benyon.jpajwt.services;

import io.benyon.jpajwt.models.User;
import io.benyon.jpajwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;
  
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    User user = userRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
    return UserDetailsImpl.build(user);
  }
  
  public List<User> findAll(){
    return userRepository.findAll();
  }
}
