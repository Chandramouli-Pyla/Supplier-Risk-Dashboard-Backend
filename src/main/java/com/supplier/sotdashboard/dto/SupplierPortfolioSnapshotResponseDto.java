package com.supplier.sotdashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierPortfolioSnapshotResponseDto {

    private Long id;
    private String siteCode;
    private String supplier;
    private String address;
    private String country;
    private String postalCode;
    private String segmentStatus;
    private String supplierRegion;

    private String q1Status;
    private Integer q1Score;

    private List<Map<String, Object>> siteSegmentRows;

    private Map<String, Object> ppap;
    private String commercialDate;
    private String commercialDistress;
    private Integer commercialFhr;

    private Map<String, Object> tvm;
    private Map<String, Object> behindSched;
    private Map<String, Object> dpr;
    private Map<String, Object> premiumFreight;
    private Map<String, Object> vor;
    private Map<String, Object> wers;
    private Map<String, Object> srea;
    private Map<String, Object> ecarOee;
    private Map<String, Object> fcsdBacklog;
    private Map<String, Object> msa;

    private Integer systemicKpi;
    private Integer behindKpi;
    private Integer demandKpi;

    private List<Map<String, Object>> releaseVsRequired;
    private Map<String, Object> sotBreakdown;
    private Map<String, Object> plantBreakdown;
    private List<Map<String, Object>> trendChart;

    private Map<String, Object> summaryRow1;
    private Map<String, Object> summaryRow2;
    private Map<String, Object> summaryRow3;

    private Map<String, Object> productPortfolio;
}