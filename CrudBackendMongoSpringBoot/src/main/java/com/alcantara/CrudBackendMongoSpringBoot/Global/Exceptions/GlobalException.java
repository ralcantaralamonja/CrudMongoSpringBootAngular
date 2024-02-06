package com.alcantara.CrudBackendMongoSpringBoot.Global.Exceptions;

import com.alcantara.CrudBackendMongoSpringBoot.Global.Dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    //setea el mensaje de Not Found
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<MessageDTO>throwNotFoundException(ResourceNotFound ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(new MessageDTO(HttpStatus.NOT_FOUND,ex.getMessage()));
    }
    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MessageDTO>throwAttributeException(AttributeException ex){

        return ResponseEntity.badRequest().
                body(new MessageDTO(HttpStatus.BAD_REQUEST,ex.getMessage()));
    }


}
