package com.supplier.sotdashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "freight_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreightRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_code", nullable = false, unique = true)
    private String recordCode;

    @Column(nullable = false)
    private String vhm;

    @Column(name = "site_code", nullable = false)
    private String siteCode;

    @Column(name = "site_name", nullable = false)
    private String siteName;

    @Column(name = "part_number", nullable = false)
    private String partNumber;

    @Column(name = "freight_month", nullable = false)
    private String freightMonth;

    @Column(name = "dpr_month", nullable = false)
    private String dprMonth;

    @Column(name = "ship_year", nullable = false)
    private Integer shipYear;

    @Column(nullable = false)
    private Integer qty;

    @Column(name = "total_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalAmount;
}