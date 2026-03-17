package com.supplier.sotdashboard.repository;

import com.supplier.sotdashboard.entity.AdhocFilterPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdhocFilterPanelRepository extends JpaRepository<AdhocFilterPanel, Long> {
}