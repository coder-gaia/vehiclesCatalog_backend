package com.alexandreG.UserService.service;

import com.alexandreG.UserService.DTO.CreateUserDTO;
import com.alexandreG.UserService.DTO.JwtTokenDTO;
import com.alexandreG.UserService.DTO.LoginUserDTO;
import com.alexandreG.UserService.DTO.UserDTO;
import com.alexandreG.UserService.models.ModelUserDetailsImpl;
import com.alexandreG.UserService.models.ModelRole;
import com.alexandreG.UserService.repository.IRoleRepository;
import com.alexandreG.UserService.repository.IUserRepository;
import com.alexandreG.UserService.models.ModelUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDTO createUser(CreateUserDTO createUserDto) {
        if (userRepository.findByEmail(createUserDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        List<ModelRole> roles = createUserDto.getRoles().stream()
                .map(role -> roleRepository.findByName(role.name())
                        .orElseThrow(() -> new RuntimeException("Role not found: " + role.name())))
                .collect(Collectors.toList());

        String encodedPassword = passwordEncoder.encode(createUserDto.getPassword());

        ModelUser newUser = ModelUser.builder()
                .username(createUserDto.getUsername())
                .email(createUserDto.getEmail())
                .password(encodedPassword)
                .roles(roles)
                .build();
        userRepository.save(newUser);
        return null;
    }


    public JwtTokenDTO authenticateUser(LoginUserDTO loginUserDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        ModelUserDetailsImpl userDetails = (ModelUserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtTokenService.generateToken(userDetails);

        return new JwtTokenDTO(jwtToken);
    }

    public List<ModelUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}
