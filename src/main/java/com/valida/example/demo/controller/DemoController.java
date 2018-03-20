package com.valida.example.demo.controller;


import com.valida.example.demo.domain.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DemoController {
    @RequestMapping("/test")
    public String test(@RequestBody @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            for (Object error : result.getAllErrors()) {
                FieldError fieldError = (FieldError) error;
                System.out.println(fieldError.getField() + fieldError.getDefaultMessage());
            }
        }
        System.out.println(student.toString());
        return "success";
    }
}
