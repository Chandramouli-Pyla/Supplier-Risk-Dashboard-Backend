package com.supplier.sotdashboard.repository;

import com.supplier.sotdashboard.entity.FreightRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightRecordRepository extends JpaRepository<FreightRecord, Long> {
}