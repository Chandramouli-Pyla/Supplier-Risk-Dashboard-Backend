package com.supplier.sotdashboard.controller;

import com.supplier.sotdashboard.dto.SupplierPortfolioSnapshotResponseDto;
import com.supplier.sotdashboard.service.SupplierPortfolioSnapshotService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/supplier-portfolio")
@CrossOrigin(origins = "https://supplier-risk-dashboard-795019603251.us-central1.run.app")
public class SupplierPortfolioSnapshotController {

    private final SupplierPortfolioSnapshotService service;

    public SupplierPortfolioSnapshotController(SupplierPortfolioSnapshotService service) {
        this.service = service;
    }

    @GetMapping
    public List<SupplierPortfolioSnapshotResponseDto> getAllSnapshots() {
        return service.getAllSnapshots();
    }
}