/**
 * @author alexandre.gaia
 */


package com.alexandreG.VehicleService.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vehicles")
public class Vehicle {

    @Id
    private String id;

    private String brand;
    private String model;
    private String year;
    private String color;
    private Double price;
    private String km;
    private String image;
    private String location;
}
