package com.example.course_work_2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason =  "Привышен лимит")
public class IllegalArgumentException extends RuntimeException {

}
