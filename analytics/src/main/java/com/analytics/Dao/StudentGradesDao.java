package com.analytics.Dao;

import com.analytics.model.GradesStatistics;
import com.analytics.model.StudentGrades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentGradesDao {



    @Autowired
    private JdbcTemplate template;

    private static final class StudentGradesMapper implements RowMapper<StudentGrades> {
        @Override
        public StudentGrades mapRow(ResultSet rs, int rowNum) throws SQLException {
            StudentGrades student = new StudentGrades();
            student.setGrade(rs.getDouble("grade"));
            student.setStudentName(rs.getString("student_name"));
            return student;
        }
    }




    public List<StudentGrades> readGrades(){
        return template.query("SELECT * FROM grades" ,new StudentGradesMapper() );
    }

    public void writeStatistics(GradesStatistics gradesStatistics){
        template.update("INSERT INTO statistics values(?,?,?,?)" , "1" , gradesStatistics.getMin() , gradesStatistics.getMax(),gradesStatistics.getAvg());
    }

}
