package com.example.course_work_2.services.interfaces;


import com.example.course_work_2.dto.Question;

import java.util.Collection;

public interface ExamService {
    Collection<Question> getQuestions(int amount);

}
