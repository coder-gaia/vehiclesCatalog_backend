/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO {

    private String email;

    private String password;
}
