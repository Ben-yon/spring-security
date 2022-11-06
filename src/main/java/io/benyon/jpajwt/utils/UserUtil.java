package io.benyon.jpajwt.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {
  public static Authentication user(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication;
  }
}
