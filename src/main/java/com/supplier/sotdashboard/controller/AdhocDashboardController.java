package com.supplier.sotdashboard.controller;

import com.supplier.sotdashboard.dto.AdhocFilterPanelResponseDto;
import com.supplier.sotdashboard.dto.AdhocSelectedItemsResponseDto;
import com.supplier.sotdashboard.dto.AdhocTableRowResponseDto;
import com.supplier.sotdashboard.service.AdhocDashboardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/adhoc")
@CrossOrigin(origins = "https://supplier-risk-dashboard-795019603251.us-central1.run.app")
//@CrossOrigin(origins ="http://localhost:4200")
public class AdhocDashboardController {

    private final AdhocDashboardService adhocDashboardService;

    public AdhocDashboardController(AdhocDashboardService adhocDashboardService) {
        this.adhocDashboardService = adhocDashboardService;
    }

    @GetMapping("/panels")
    public List<AdhocFilterPanelResponseDto> getPanels() {
        return adhocDashboardService.getAllPanels();
    }

    @GetMapping("/selected-items")
    public List<AdhocSelectedItemsResponseDto> getSelectedItems() {
        return adhocDashboardService.getAllSelectedItems();
    }

    @GetMapping("/table-rows")
    public List<AdhocTableRowResponseDto> getTableRows() {
        return adhocDashboardService.getAllTableRows();
    }
}