package com.example.course_work_2.controllers;

import com.example.course_work_2.dto.Question;
import com.example.course_work_2.services.interfaces.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public ResponseEntity<Question> addQuestion(@RequestParam String question, @RequestParam String answer) {
        var result = questionService.add(question, answer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Collection<Question>> getAllQuestion() {
        return new ResponseEntity<>(questionService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/remove")
    public ResponseEntity<Question> removeQuestion(@RequestParam String question, @RequestParam String answer) {
        var result = new Question(question, answer);
        questionService.remove(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
