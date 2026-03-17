package com.supplier.sotdashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supplier_portfolio_snapshots")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierPortfolioSnapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "site_code", nullable = false)
    private String siteCode;

    @Column(nullable = false)
    private String supplier;

    @Column(nullable = false, length = 500)
    private String address;

    @Column(nullable = false)
    private String country;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "segment_status", nullable = false)
    private String segmentStatus;

    @Column(name = "supplier_region", nullable = false)
    private String supplierRegion;

    @Column(name = "q1_status", nullable = false)
    private String q1Status;

    @Column(name = "q1_score", nullable = false)
    private Integer q1Score;

    @Lob
    @Column(name = "site_segment_rows", columnDefinition = "LONGTEXT")
    private String siteSegmentRowsJson;

    @Lob
    @Column(name = "ppap", columnDefinition = "LONGTEXT")
    private String ppapJson;

    @Column(name = "commercial_date")
    private String commercialDate;

    @Column(name = "commercial_distress")
    private String commercialDistress;

    @Column(name = "commercial_fhr")
    private Integer commercialFhr;

    @Lob
    @Column(name = "tvm", columnDefinition = "LONGTEXT")
    private String tvmJson;

    @Lob
    @Column(name = "behind_sched", columnDefinition = "LONGTEXT")
    private String behindSchedJson;

    @Lob
    @Column(name = "dpr", columnDefinition = "LONGTEXT")
    private String dprJson;

    @Lob
    @Column(name = "premium_freight", columnDefinition = "LONGTEXT")
    private String premiumFreightJson;

    @Lob
    @Column(name = "vor", columnDefinition = "LONGTEXT")
    private String vorJson;

    @Lob
    @Column(name = "wers", columnDefinition = "LONGTEXT")
    private String wersJson;

    @Lob
    @Column(name = "srea", columnDefinition = "LONGTEXT")
    private String sreaJson;

    @Lob
    @Column(name = "ecar_oee", columnDefinition = "LONGTEXT")
    private String ecarOeeJson;

    @Lob
    @Column(name = "fcsd_backlog", columnDefinition = "LONGTEXT")
    private String fcsdBacklogJson;

    @Lob
    @Column(name = "msa", columnDefinition = "LONGTEXT")
    private String msaJson;

    @Column(name = "systemic_kpi")
    private Integer systemicKpi;

    @Column(name = "behind_kpi")
    private Integer behindKpi;

    @Column(name = "demand_kpi")
    private Integer demandKpi;

    @Lob
    @Column(name = "release_vs_required", columnDefinition = "LONGTEXT")
    private String releaseVsRequiredJson;

    @Lob
    @Column(name = "sot_breakdown", columnDefinition = "LONGTEXT")
    private String sotBreakdownJson;

    @Lob
    @Column(name = "plant_breakdown", columnDefinition = "LONGTEXT")
    private String plantBreakdownJson;

    @Lob
    @Column(name = "trend_chart", columnDefinition = "LONGTEXT")
    private String trendChartJson;

    @Lob
    @Column(name = "summary_row_1", columnDefinition = "LONGTEXT")
    private String summaryRow1Json;

    @Lob
    @Column(name = "summary_row_2", columnDefinition = "LONGTEXT")
    private String summaryRow2Json;

    @Lob
    @Column(name = "summary_row_3", columnDefinition = "LONGTEXT")
    private String summaryRow3Json;

    @Lob
    @Column(name = "product_portfolio", columnDefinition = "LONGTEXT")
    private String productPortfolioJson;
}