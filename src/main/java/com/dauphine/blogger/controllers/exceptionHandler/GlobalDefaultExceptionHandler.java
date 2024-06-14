package com.dauphine.blogger.controllers.exceptionHandler;

import com.dauphine.blogger.exceptions.CategoryNameAlreadyExists;
import com.dauphine.blogger.exceptions.PostNotFoundByIdException;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class.getName());

    @ExceptionHandler({
            CategoryNotFoundByIdException.class,
            PostNotFoundByIdException.class,
    })

    public ResponseEntity<String> handleNotFoundException(Exception ex) {
        logger.warn("[NOT FOUND] {}", ex.getMessage());
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler({CategoryNameAlreadyExists.class})
    public ResponseEntity<String> handleCategoryNameAlreadyExists(Exception ex) {
        logger.warn("[WRONG NAME] {}", ex.getMessage());
        return ResponseEntity.status(400).body(ex.getMessage());
    }
}
