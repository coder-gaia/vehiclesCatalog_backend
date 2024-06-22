/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.models;

import com.alexandreG.UserService.Enum.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@Builder
@Document(collection = "roles")
public class ModelRole {

    @Id
    private String id;

    private Role name;


}
