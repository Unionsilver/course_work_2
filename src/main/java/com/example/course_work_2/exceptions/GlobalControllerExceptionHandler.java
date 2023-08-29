package com.example.course_work_2.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends RuntimeException {
    public GlobalControllerExceptionHandler(String message) {
        super(message);
    }
}
