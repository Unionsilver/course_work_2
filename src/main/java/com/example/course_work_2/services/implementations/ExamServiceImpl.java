package com.example.course_work_2.services.implementations;

import com.example.course_work_2.dto.Question;
import com.example.course_work_2.exceptions.GlobalControllerExceptionHandler;
import com.example.course_work_2.services.interfaces.ExamService;
import com.example.course_work_2.services.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
@Service
public class ExamServiceImpl implements ExamService {
    Random random;
    QuestionService questionService;

    public ExamServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int limit = 15;

        if (amount > limit) {
            throw new GlobalControllerExceptionHandler("Requested more questions than available.");
        }
        Collection<Question> questions = new HashSet<>();


        for (int i = 0; i < amount; i++) {
            Question randomQuestion = questionService.getRandomQuestion();
            questions.add(randomQuestion);
        }

        return questions;
    }
}
