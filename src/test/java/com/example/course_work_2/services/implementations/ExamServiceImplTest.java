package com.example.course_work_2.services.implementations;

import com.example.course_work_2.dto.Question;
import com.example.course_work_2.services.interfaces.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExamServiceImplTest {
    @Mock
    QuestionService questionService;

    @InjectMocks
    ExamServiceImpl underTest;
    Question question1 = new Question("Q3", "A1");
    Question question2 = new Question("Q2", "A2");


    @Test
    void getQuestions_enoughQuestionInList_setOfQuestionsReturned() {
        int amount = 2;
        when(questionService.getAll()).thenReturn(List.of(question1,question2));

        Collection<Question> result = underTest.getQuestions(amount);

        assertEquals(amount, result.size());
        assertEquals(amount,result.stream().distinct().count());


    }
}