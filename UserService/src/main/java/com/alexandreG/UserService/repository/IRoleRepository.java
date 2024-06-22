/**
 * @author alexandre.gaia
 */
package com.alexandreG.UserService.repository;

import com.alexandreG.UserService.models.ModelRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface IRoleRepository extends MongoRepository<ModelRole, String> {
    Optional<ModelRole> findByName(String name);
}
