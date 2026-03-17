package com.supplier.sotdashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreightRecordResponseDto {

    private Long id;
    private String recordCode;
    private String vhm;
    private String siteCode;
    private String siteName;
    private String partNumber;
    private String freightMonth;
    private String dprMonth;
    private Integer shipYear;
    private Integer qty;
    private BigDecimal totalAmount;
}