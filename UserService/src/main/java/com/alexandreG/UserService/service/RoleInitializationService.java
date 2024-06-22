package com.alexandreG.UserService.service;

import com.alexandreG.UserService.Enum.Role;
import com.alexandreG.UserService.models.ModelRole;
import com.alexandreG.UserService.repository.IRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleInitializationService {

    @Autowired
    private IRoleRepository roleRepository;

    @PostConstruct
    public void init() {
        saveRoleIfNotExist("USER");
        saveRoleIfNotExist("ADMIN");
    }

    private void saveRoleIfNotExist(String roleName) {
        if (!roleRepository.findByName(roleName).isPresent()) {
            roleRepository.save(ModelRole.builder().name(Role.valueOf(roleName)).build());
        }
    }
}
