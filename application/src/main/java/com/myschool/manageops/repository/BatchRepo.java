package com.myschool.manageops.repository;

import com.myschool.manageops.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BatchRepo extends JpaRepository<Batch, UUID> {
    Batch findByIdAndInstituteId(UUID id, UUID instituteId);

    List<Batch> findByInstituteId(UUID instituteId);
}
