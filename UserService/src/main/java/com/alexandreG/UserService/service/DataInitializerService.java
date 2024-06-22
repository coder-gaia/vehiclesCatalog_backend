package com.alexandreG.UserService.service;

import com.alexandreG.UserService.Enum.Role;
import com.alexandreG.UserService.models.ModelRole;
import com.alexandreG.UserService.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataInitializerService {

    @Autowired
    private IRoleRepository roleRepository;

    @PostConstruct
    public void initialize() {
        if (!roleRepository.findByName(String.valueOf(Role.ADMIN)).isPresent()) {
            ModelRole adminRole = ModelRole.builder()
                    .name(Role.ADMIN)
                    .build();
            roleRepository.save(adminRole);
        }
    }
}
