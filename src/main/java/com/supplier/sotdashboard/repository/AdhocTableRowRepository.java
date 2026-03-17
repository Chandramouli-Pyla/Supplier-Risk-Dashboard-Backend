package com.supplier.sotdashboard.repository;

import com.supplier.sotdashboard.entity.AdhocTableRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdhocTableRowRepository extends JpaRepository<AdhocTableRow, Long> {
}