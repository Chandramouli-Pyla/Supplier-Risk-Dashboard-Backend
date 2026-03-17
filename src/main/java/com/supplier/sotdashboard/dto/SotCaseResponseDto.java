package com.supplier.sotdashboard.dto;

import com.supplier.sotdashboard.enums.CaseType;
import com.supplier.sotdashboard.enums.Status;
import com.supplier.sotdashboard.enums.SupplierRegion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SotCaseResponseDto {

    private Long id;
    private String caseCode;
    private LocalDate weekDate;
    private String supplier;
    private SupplierRegion supplierRegion;
    private String siteCode;
    private String staVhm;
    private CaseType caseType;
    private Integer delayDays;
    private Boolean activeSite;
    private Status status;
}