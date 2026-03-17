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
public class AdhocSelectedItemsResponseDto {

    private Long id;
    private String panelKey;
    private List<String> selectedItems;
}