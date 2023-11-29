package com.myschool.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Courses extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private UUID instituteId;

    private int categoryId;

    private int batchSize;

    private int instructorId;

    private int fees;
}
