package com.blog.services.Implementations;

import com.blog.models.Entities.User;
import org.springframework.security.core.GrantedAuthority;
import com.blog.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
public class MyUserDetailsService implements UserDetailsService{

    private UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Iterable<User> allUsers = userService.getAllUsers();
            User user = new User();
            for (User user1 : allUsers){
                user = user1;
            }
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                        user.getPassword(), getAuthorities(user));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Set<GrantedAuthority> getAuthorities(User user){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().toString());
        authorities.add(grantedAuthority);
        return authorities;
    }
}
