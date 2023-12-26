package com.myschool.commons.domain.dto;

import com.myschool.commons.constants.UserRole;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {
    private UUID id;
    private ProfilePictureResponse profilePicture;
    private String name;
    private ContactResponse contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}