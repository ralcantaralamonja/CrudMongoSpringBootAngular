package com.alcantara.CrudBackendMongoSpringBoot.Crud.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String description;
    private Double price;

}
