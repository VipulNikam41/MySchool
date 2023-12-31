package com.myschool.commons.dto;

import com.myschool.constants.Privilege;
import com.myschool.constants.StaffRole;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StaffRequest {
    private ProfilePictureRequest profilePicture;
    private String name;
    private ContactRequest contact;
    private String dateOfBirth;
    private List<Privilege> privileges;
    private StaffRole primaryGoal;
}
