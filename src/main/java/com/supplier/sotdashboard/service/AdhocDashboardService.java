package com.supplier.sotdashboard.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplier.sotdashboard.dto.AdhocFilterPanelResponseDto;
import com.supplier.sotdashboard.dto.AdhocSelectedItemsResponseDto;
import com.supplier.sotdashboard.dto.AdhocTableRowResponseDto;
import com.supplier.sotdashboard.entity.AdhocFilterPanel;
import com.supplier.sotdashboard.entity.AdhocSelectedItems;
import com.supplier.sotdashboard.entity.AdhocTableRow;
import com.supplier.sotdashboard.repository.AdhocFilterPanelRepository;
import com.supplier.sotdashboard.repository.AdhocSelectedItemsRepository;
import com.supplier.sotdashboard.repository.AdhocTableRowRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdhocDashboardService {

    private final AdhocFilterPanelRepository adhocFilterPanelRepository;
    private final AdhocSelectedItemsRepository adhocSelectedItemsRepository;
    private final AdhocTableRowRepository adhocTableRowRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AdhocDashboardService(
            AdhocFilterPanelRepository adhocFilterPanelRepository,
            AdhocSelectedItemsRepository adhocSelectedItemsRepository,
            AdhocTableRowRepository adhocTableRowRepository
    ) {
        this.adhocFilterPanelRepository = adhocFilterPanelRepository;
        this.adhocSelectedItemsRepository = adhocSelectedItemsRepository;
        this.adhocTableRowRepository = adhocTableRowRepository;
    }

    public List<AdhocFilterPanelResponseDto> getAllPanels() {
        return adhocFilterPanelRepository.findAll()
                .stream()
                .map(this::mapPanelToDto)
                .toList();
    }

    public List<AdhocSelectedItemsResponseDto> getAllSelectedItems() {
        return adhocSelectedItemsRepository.findAll()
                .stream()
                .map(this::mapSelectedItemsToDto)
                .toList();
    }

    public List<AdhocTableRowResponseDto> getAllTableRows() {
        return adhocTableRowRepository.findAll()
                .stream()
                .map(this::mapTableRowToDto)
                .toList();
    }

    private AdhocFilterPanelResponseDto mapPanelToDto(AdhocFilterPanel entity) {
        return AdhocFilterPanelResponseDto.builder()
                .id(entity.getId())
                .key(entity.getPanelKey())
                .title(entity.getTitle())
                .countLabel(entity.getCountLabel())
                .items(parseStringList(entity.getItemsJson()))
                .build();
    }

    private AdhocSelectedItemsResponseDto mapSelectedItemsToDto(AdhocSelectedItems entity) {
        return AdhocSelectedItemsResponseDto.builder()
                .id(entity.getId())
                .panelKey(entity.getPanelKey())
                .selectedItems(parseStringList(entity.getSelectedItemsJson()))
                .build();
    }

    private AdhocTableRowResponseDto mapTableRowToDto(AdhocTableRow entity) {
        return AdhocTableRowResponseDto.builder()
                .id(entity.getId())
                .siteCode(entity.getSiteCode())
                .vhm(entity.getVhm())
                .siteName(entity.getSiteName())
                .cityStateCountry(entity.getCityStateCountry())
                .week(entity.getWeek())
                .releaseGtMppcGtMpw(entity.getReleaseGtMppcGtMpw())
                .releaseGtMppcLtMpw(entity.getReleaseGtMppcLtMpw())
                .releaseLtMppcGtMpw(entity.getReleaseLtMppcGtMpw())
                .behindScheduleFlag(entity.getBehindScheduleFlag())
                .behindScheduleQuantity(entity.getBehindScheduleQuantity())
                .behindCount(entity.getBehindCount())
                .q1Status(entity.getQ1Status())
                .grossDprLoss(entity.getGrossDprLoss())
                .build();
    }

    private List<String> parseStringList(String json) {
        try {
            if (json == null || json.isBlank()) {
                return Collections.emptyList();
            }
            return objectMapper.readValue(json, new TypeReference<List<String>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON string list", e);
        }
    }
}