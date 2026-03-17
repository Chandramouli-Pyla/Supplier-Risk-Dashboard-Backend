package com.supplier.sotdashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdhocTableRowResponseDto {

    private Long id;
    private String siteCode;
    private String vhm;
    private String siteName;
    private String cityStateCountry;
    private String week;
    private Integer releaseGtMppcGtMpw;
    private Integer releaseGtMppcLtMpw;
    private Integer releaseLtMppcGtMpw;
    private Integer behindScheduleFlag;
    private Integer behindScheduleQuantity;
    private Integer behindCount;
    private String q1Status;
    private Integer grossDprLoss;
}