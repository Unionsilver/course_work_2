package com.example.course_work_2.services.implementations;

import com.example.course_work_2.dto.Question;
import com.example.course_work_2.exceptions.ControllerException;
import com.example.course_work_2.services.interfaces.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        when(questionService.getRandomQuestion()).thenReturn(question1, question1, question2);

        Collection<Question> result1 = underTest.getQuestions(amount);

        assertEquals(amount, result1.size());
        assertEquals(amount, result1.stream().distinct().count());
    }

    @Test
    void qetQuestions_amountMoreSize_thrownTooManyRequestException() {
        when(questionService.getRandomQuestion()).thenReturn(question1, question1, question2);
        assertThrows(IllegalArgumentException.class, () -> underTest.getQuestions(2));
    }

    @Test
    void qetQuestions_amountLessZero_thrownInvalidParameterValueException() {
        assertThrows(ControllerException.class, () -> underTest.getQuestions(-2));
    }

    @Test
    void qetQuestions_amountNoMoreSize_returnSetOfRandomQuestions() {
        when(questionService.getRandomQuestion()).thenReturn(question1, question1, question2)
                .thenReturn(new Question("вопрос1", "ответ1"))
                .thenReturn(new Question("вопрос2", "ответ2"));

        Set<Question> result = (Set<Question>) underTest.getQuestions(3);
        Set<Question> expected = new HashSet<>(List.of(
                new Question("вопрос1", "ответ1"),
                new Question("вопрос2", "ответ2")));
        assertEquals(expected, result);
    }
}