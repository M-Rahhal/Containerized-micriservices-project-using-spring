package com.showResult;

import com.showResult.model.GradesStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class EndPointController {


    @Autowired
    private JdbcTemplate template;

    @PostMapping("/")
    public String showResult(@RequestBody String id ){
        GradesStatistics statistics = template.queryForObject("SELECT min , max , avg FROM statistics WHERE id=?" , new GradeStatisticsMapper() , id);
        return statistics.toString();
    }



    private static final class GradeStatisticsMapper implements RowMapper<GradesStatistics> {
        @Override
        public GradesStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
            GradesStatistics statistics = new GradesStatistics();
            statistics.setAvg(rs.getDouble("avg"));
            statistics.setMin(rs.getDouble("min"));
            statistics.setMax(rs.getDouble("max"));
            return statistics;
        }
    }


}
