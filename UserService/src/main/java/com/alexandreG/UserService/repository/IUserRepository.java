/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.repository;

import com.alexandreG.UserService.models.ModelUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<ModelUser, Long> {

    Optional<ModelUser> findByUsername(String username);

    Optional<ModelUser> findByEmail(String email);

    void deleteByUsername(String username);
}
