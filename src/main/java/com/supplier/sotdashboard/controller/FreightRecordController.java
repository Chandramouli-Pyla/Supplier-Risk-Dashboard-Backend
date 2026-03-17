package com.supplier.sotdashboard.controller;

import com.supplier.sotdashboard.dto.FreightRecordResponseDto;
import com.supplier.sotdashboard.service.FreightRecordService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/freight-records")
@CrossOrigin(origins = "https://supplier-risk-dashboard-795019603251.us-central1.run.app")
public class FreightRecordController {

    private final FreightRecordService freightRecordService;

    public FreightRecordController(FreightRecordService freightRecordService) {
        this.freightRecordService = freightRecordService;
    }

    @GetMapping
    public List<FreightRecordResponseDto> getAllFreightRecords() {
        return freightRecordService.getAllFreightRecords();
    }
}