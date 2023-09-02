package com.example.course_work_2.services.implementations;

import com.example.course_work_2.dto.Question;
import com.example.course_work_2.exceptions.ControllerException;
import com.example.course_work_2.services.interfaces.ExamService;
import com.example.course_work_2.services.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExamServiceImpl implements ExamService {

   private final QuestionService questionService;

    public ExamServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();

        if (questionService.getAll().size() < amount) {
            throw new ControllerException();
        }
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());

        }
        return questions;
    }
}
