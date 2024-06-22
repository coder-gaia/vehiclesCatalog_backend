/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.service;

import com.alexandreG.UserService.models.ModelUser;
import com.alexandreG.UserService.models.ModelUserDetailsImpl;
import com.alexandreG.UserService.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ModelUser modelUser = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("user not found!"));
        return new ModelUserDetailsImpl(modelUser);
    }
}
