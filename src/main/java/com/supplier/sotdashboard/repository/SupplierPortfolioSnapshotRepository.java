package com.supplier.sotdashboard.repository;

import com.supplier.sotdashboard.entity.SupplierPortfolioSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierPortfolioSnapshotRepository extends JpaRepository<SupplierPortfolioSnapshot, Long> {
}