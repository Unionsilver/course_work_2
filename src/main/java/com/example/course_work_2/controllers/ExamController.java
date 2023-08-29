package com.example.course_work_2.controllers;

import com.example.course_work_2.dto.Question;
import com.example.course_work_2.services.interfaces.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/questions")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examService.getQuestions(amount);
    }
}