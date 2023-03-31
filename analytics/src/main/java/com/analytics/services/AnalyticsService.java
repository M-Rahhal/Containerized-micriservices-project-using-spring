package com.analytics.services;


import com.analytics.Dao.StudentGradesDao;
import com.analytics.model.GradesStatistics;
import com.analytics.model.StudentGrades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {
    @Autowired
    private StudentGradesDao dao;


    public void doService(){
        List<StudentGrades> grades = dao.readGrades();
        GradesStatistics statistics = getStatistics(grades);
        dao.writeStatistics(statistics);
    }

    private GradesStatistics getStatistics(List<StudentGrades> grades){
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double avg = 0;

        for (StudentGrades grade : grades){
            if (grade.getGrade()<min)
                min=grade.getGrade();
            if (grade.getGrade()>max)
                max=grade.getGrade();
            avg+=grade.getGrade();
        }
        return new GradesStatistics(min , max , avg/grades.size());
    }


}
