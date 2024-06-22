/**
 * @author alexandre.gaia
 */

package com.alexandreG.VehicleService.repository;

import com.alexandreG.VehicleService.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends MongoRepository<Vehicle, String> {
}
