package com.supplier.sotdashboard.entity;

import com.supplier.sotdashboard.enums.CaseType;
import com.supplier.sotdashboard.enums.SupplierRegion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "sot_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SotCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "case_code", nullable = false, unique = true)
    private String caseCode;

    @Column(name = "week_date", nullable = false)
    private LocalDate weekDate;

    @Column(nullable = false)
    private String supplier;

    @Enumerated(EnumType.STRING)
    @Column(name = "supplier_region", nullable = false)
    private SupplierRegion supplierRegion;

    @Column(name = "site_code", nullable = false)
    private String siteCode;

    @Column(name = "sta_vhm", nullable = false)
    private String staVhm;

    @Enumerated(EnumType.STRING)
    @Column(name = "case_type", nullable = false)
    private CaseType caseType;

    @Column(name = "delay_days")
    private Integer delayDays;

    @Column(name = "active_site", nullable = false)
    private Boolean activeSite;
}