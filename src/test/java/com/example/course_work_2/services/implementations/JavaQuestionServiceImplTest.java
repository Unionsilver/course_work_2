package com.example.course_work_2.services.implementations;

import com.example.course_work_2.dto.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {
    JavaQuestionServiceImpl underTest = new JavaQuestionServiceImpl();
    Question question1 = new Question("Q3", "A1");
    Question question2 = new Question("Q2", "A2");

    @Test
    void add__questionAddedAndReturned() {
        Question result = underTest.add(question1.getQuestion(),question1.getAnswer());
        assertTrue(underTest.getAll().contains(question1));
        assertEquals(question1,result);
    }

    @Test
    void getAll_questionsAreInList_listWithQuestionReturn() {
        underTest.add(question1);
        underTest.add(question2);
        Collection<Question> result = underTest.getAll();
        assertTrue(result.containsAll(Set.of(question1,question2)));
    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
    }

    @Test
    void getRandomQuestion() {
    }
}