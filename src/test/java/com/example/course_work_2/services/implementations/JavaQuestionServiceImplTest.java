package com.example.course_work_2.services.implementations;

import com.example.course_work_2.dto.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {
    JavaQuestionServiceImpl underTest = new JavaQuestionServiceImpl();
    Question question1 = new Question("Q3", "A1");
    Question question2 = new Question("Q2", "A2");

    @Test
    void add__questionAddedAndReturned() {
        Question result = underTest.add(question1.getQuestion(), question1.getAnswer());
        assertTrue(

                underTest.getAll().contains(question1)

        );
        assertEquals(question1, result);
    }

    @Test
    void getAll_questionsAreInList_listWithQuestionReturn() {
        underTest.add(question1);
        underTest.add(question2);
        Collection<Question> result = underTest.getAll();
        assertTrue(result.containsAll(Set.of(question1, question2)));
    }

    @Test
    void add_questionsFieldsAddedAndReturned() {

        Question result = underTest.add(question1.getQuestion(), question1.getAnswer());
        assertEquals(question1, result);
        assertEquals(result, question1);
    }

    @Test
    void remove_questionRemovedAndReturned() {
        Question addedQuestion = underTest.add("a", "б");

        Question removedQuestion = underTest.remove(addedQuestion);

        assertEquals(addedQuestion, removedQuestion);
        assertFalse(

                underTest.getAll().contains(addedQuestion)

        );
        }

        @Test
        void getRandomQuestion_NotEmptySet () {

            underTest.add(question1);
            underTest.add(question2);

            Question result = underTest.getRandomQuestion();
            assertTrue(underTest.getAll().contains(result));

        }
        @Test
        void getRandomQuestion_EmptySet () {

            assertThrows(RuntimeException.class, () -> underTest.getRandomQuestion());
        }
}
