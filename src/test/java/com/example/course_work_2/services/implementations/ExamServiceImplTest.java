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

    Collection<Question> questions = List.of(question1, question2);

    @Test
    void getQuestions_enoughQuestionInList_setOfQuestionsReturned() {

        int amount = 2;
        when(questionService.getRandomQuestion()).thenReturn(question1, question1, question2);
        when(questionService.getAll()).thenReturn(questions);

        Collection<Question> actual = underTest.getQuestions(amount);

        Collection<Question> expect = List.of(question2, question1);
        assertTrue(expect.containsAll(actual));

        assertEquals(amount, actual.size());



        assertEquals(amount, actual.stream().distinct().count());

    }

    @Test
    void qetQuestions_amountMoreSize_thrownTooManyRequestException() {
        when(questionService.getAll()).thenReturn(questions);
        assertThrows(ControllerException.class, () -> underTest.getQuestions(4));
    }
}