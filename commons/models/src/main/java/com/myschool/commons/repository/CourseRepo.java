package com.myschool.commons.repository;

import com.myschool.commons.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepo extends JpaRepository<Course, UUID> {
    List<Course> findByInstituteId(UUID instituteId);
}
