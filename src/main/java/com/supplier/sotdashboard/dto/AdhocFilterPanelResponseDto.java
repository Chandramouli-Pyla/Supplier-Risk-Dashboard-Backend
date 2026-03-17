package com.supplier.sotdashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdhocFilterPanelResponseDto {

    private Long id;
    private String key;
    private String title;
    private String countLabel;
    private List<String> items;
}