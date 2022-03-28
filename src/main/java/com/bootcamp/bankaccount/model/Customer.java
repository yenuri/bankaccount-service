package com.bootcamp.bankaccount.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String dni;
    private String customerType;
    private String status;
    private String name;
}
