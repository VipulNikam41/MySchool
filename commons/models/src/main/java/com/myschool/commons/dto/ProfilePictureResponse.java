package com.myschool.commons.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfilePictureResponse {
    private String color;
    private String imageLink;
}
