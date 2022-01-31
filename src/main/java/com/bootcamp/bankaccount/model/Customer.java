package com.bootcamp.bankaccount.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private Long id;
    private String dni;
    private String customerType;
    private String status;
}
