/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.controller;

import com.alexandreG.UserService.DTO.CreateUserDTO;
import com.alexandreG.UserService.DTO.JwtTokenDTO;
import com.alexandreG.UserService.DTO.LoginUserDTO;
import com.alexandreG.UserService.DTO.UserDTO;
import com.alexandreG.UserService.models.ModelUser;
import com.alexandreG.UserService.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    @Operation(summary = "Return all the users")
    public List<ModelUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    @Operation(summary = "User login")
    public ResponseEntity<JwtTokenDTO> loginUser(@RequestBody LoginUserDTO loginUserDto) {
        JwtTokenDTO token = userService.authenticateUser(loginUserDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/create")
    @Operation(summary = "Update creation")
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDto) {
        UserDTO createdUser = userService.createUser(createUserDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{username}")
    @Operation(summary = "Delete user by username")
    public ResponseEntity<String> deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @PostMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "Logged out successfully!";
    }
}

