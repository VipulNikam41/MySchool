package com.myschool.commons.dto;

import lombok.Data;

@Data
public class ContactRequest {
    private String email;
    private String phoneNumber;
    private String address;
    private String addressPin;
}
