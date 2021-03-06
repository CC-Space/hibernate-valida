package com.valida.example.demo.controller;


import com.valida.example.demo.domain.Student;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@RestController
public class DemoController {
    @Autowired
    private Validator validator;

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

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {
        //if (result.hasErrors()) {
        //    for (Object error : result.getAllErrors()) {
        //        FieldError fieldError = (FieldError) error;
        //        System.out.println(fieldError.getField() + fieldError.getDefaultMessage());
        //    }
        Set resultSet = validator.validate(student);
        for (Object o : resultSet) {
            ConstraintViolationImpl error = (ConstraintViolationImpl) o;

            System.out.println(error.getPropertyPath() + error.getMessage());
        }


        System.out.println(student.toString());
        return "success";
    }
}
