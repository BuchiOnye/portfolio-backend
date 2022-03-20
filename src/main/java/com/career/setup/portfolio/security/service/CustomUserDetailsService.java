package com.career.setup.portfolio.security.service;

import com.career.setup.portfolio.exceptions.NotFoundException;
import com.career.setup.portfolio.model.AppUser;
import com.career.setup.portfolio.repository.RolesRepository;
import com.career.setup.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not Found"));

        Set<String> roles = rolesRepository.getUserRoles(user.getId());

        String userRoles = roles.stream()
                .reduce("", (partialString, currentString) -> partialString + currentString);

        GrantedAuthority authority = new SimpleGrantedAuthority(userRoles);

        return new User(user.getUsername(), user.getPassword(), List.of(authority));
    }
}
