/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.DTO;

import com.alexandreG.UserService.Enum.Role;

import java.util.List;

public record UserDTO(Long id, String username, List<Role> roles) {
}
