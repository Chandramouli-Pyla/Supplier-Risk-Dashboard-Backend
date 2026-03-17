package com.supplier.sotdashboard.repository;

import com.supplier.sotdashboard.entity.AdhocSelectedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdhocSelectedItemsRepository extends JpaRepository<AdhocSelectedItems, Long> {
}