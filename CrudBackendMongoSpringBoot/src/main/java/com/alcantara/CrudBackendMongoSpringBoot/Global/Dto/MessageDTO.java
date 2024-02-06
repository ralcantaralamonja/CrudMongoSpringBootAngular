package com.alcantara.CrudBackendMongoSpringBoot.Global.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private HttpStatus status;
    private String message;
}
