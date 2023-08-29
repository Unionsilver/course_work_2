package com.example.course_work_2.services.implementations;

import com.example.course_work_2.dto.Question;
import com.example.course_work_2.services.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questionList;
    private final Random rng = new Random();

    public JavaQuestionServiceImpl() {
        this.questionList = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        var result = new Question(question, answer);
        questionList.add(result);
        return result;
    }

    @Override
    public Question add(Question question) {
        questionList.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionList.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {
        return questionList.toArray(Question[]::new)[ rng.nextInt(questionList.size())];
    }
}
