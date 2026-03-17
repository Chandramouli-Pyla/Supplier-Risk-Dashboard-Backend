package com.supplier.sotdashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adhoc_table_rows")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdhocTableRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "site_code", nullable = false)
    private String siteCode;

    @Column(nullable = false)
    private String vhm;

    @Column(name = "site_name", nullable = false)
    private String siteName;

    @Column(name = "city_state_country", nullable = false)
    private String cityStateCountry;

    @Column(nullable = false)
    private String week;

    @Column(name = "release_gt_mppc_gt_mpw", nullable = false)
    private Integer releaseGtMppcGtMpw;

    @Column(name = "release_gt_mppc_lt_mpw", nullable = false)
    private Integer releaseGtMppcLtMpw;

    @Column(name = "release_lt_mppc_gt_mpw", nullable = false)
    private Integer releaseLtMppcGtMpw;

    @Column(name = "behind_schedule_flag", nullable = false)
    private Integer behindScheduleFlag;

    @Column(name = "behind_schedule_quantity", nullable = false)
    private Integer behindScheduleQuantity;

    @Column(name = "behind_count", nullable = false)
    private Integer behindCount;

    @Column(name = "q1_status", nullable = false)
    private String q1Status;

    @Column(name = "gross_dpr_loss", nullable = false)
    private Integer grossDprLoss;
}