package com.supplier.sotdashboard.controller;

import com.supplier.sotdashboard.dto.SotCaseResponseDto;
import com.supplier.sotdashboard.service.SotCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sot-cases")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://supplier-risk-dashboard-795019603251.us-central1.run.app")
//@CrossOrigin(origins ="http://localhost:4200")
public class SotCaseController {

    private final SotCaseService sotCaseService;

    @GetMapping
    public List<SotCaseResponseDto> getAllCases() {
        return sotCaseService.getAllCases();
    }
}