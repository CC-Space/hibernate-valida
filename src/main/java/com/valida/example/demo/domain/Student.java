package com.valida.example.demo.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Student {

    @NotEmpty(message = "不能为空")
    private String name;

    @NotEmpty(message = "不能为空2")
    private String age;
}
