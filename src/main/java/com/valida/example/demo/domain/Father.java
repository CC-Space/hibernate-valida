/*
 * Copyright (c) 2005-2018 , FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.valida.example.demo.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


@Data
public class Father {
    @NotEmpty
    private String name;
}
