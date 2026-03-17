package com.supplier.sotdashboard.repository;

import com.supplier.sotdashboard.entity.SotCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SotCaseRepository extends JpaRepository<SotCase, Long> {
}