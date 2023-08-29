package com.example.course_work_2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Не достаточно вопросов в библиотеке")
public class GlobalControllerExceptionHandler extends RuntimeException {
    }

