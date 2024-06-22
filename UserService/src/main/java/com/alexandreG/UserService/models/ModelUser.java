/**
 * @author alexandre.gaia
 */


package com.alexandreG.UserService.models;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Builder
@Document(collection = "users")
public class ModelUser {

    @Id
    private String id;

    private String username;

    @Email
    private String email;

    private String password;

    @DBRef
    private List<ModelRole> roles;


}
