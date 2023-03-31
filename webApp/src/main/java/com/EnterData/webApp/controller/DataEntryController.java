package com.EnterData.webApp.controller;


import com.EnterData.webApp.data.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DataEntryController {
    @Autowired
    private JdbcTemplate template;

    @PostMapping("/show_data_form")
    public String viewDataForm(Model model){
        model.addAttribute("dataObject" , new Data());
        return"enter-data";
    }

    @PostMapping("/submit_grades")
    public String handlingGrades(@ModelAttribute Data dataObject , HttpServletRequest request){
        String data = dataObject.getData();
        String[] arr = data.split(",");
        Data[] students = new Data[arr.length];
        for (int i =0 ; i<students.length ; i++){
            students[i] = new Data();
            students[i].generateStudent(arr[i]);
        }
        for (Data d : students){
            template.update("INSERT INTO grades values(?,?)",d.getStudentName() , d.getGrade());
        }
        return"forward:/microservice";
    }



}
