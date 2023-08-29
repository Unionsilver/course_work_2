package com.example.course_work_2.services.interfaces;

import com.example.course_work_2.dto.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
