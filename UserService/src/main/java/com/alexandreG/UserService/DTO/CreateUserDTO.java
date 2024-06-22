/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.DTO;


import com.alexandreG.UserService.Enum.Role;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

    private String username;

    @Email
    private String email;

    private String password;

    private List<Role> roles;
}
