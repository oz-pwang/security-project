package org.wang.web.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.wang.web.dao.UserDao;
import org.wang.web.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yang Wang on 16/1/18.
 */
public class UserLoginService implements UserDetailsService {

  UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    org.wang.web.model.User user = userDao.findByUserName(username);

    List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
    grantedAuthorities.add(authority);
    org.springframework.security.core.userdetails.User userdetail = new org.springframework.security.core.userdetails.User(username,user.getPassword(),grantedAuthorities);

    return userdetail;
  }

  public UserDao getUserDao() {
    return userDao;
  }
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
