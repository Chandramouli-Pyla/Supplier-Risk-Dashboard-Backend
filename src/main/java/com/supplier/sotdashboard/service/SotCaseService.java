package com.supplier.sotdashboard.service;

import com.supplier.sotdashboard.dto.SotCaseResponseDto;
import com.supplier.sotdashboard.entity.SotCase;
import com.supplier.sotdashboard.repository.SotCaseRepository;
import com.supplier.sotdashboard.util.StatusUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SotCaseService {

    private final SotCaseRepository sotCaseRepository;

    public List<SotCaseResponseDto> getAllCases() {
        return sotCaseRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    private SotCaseResponseDto mapToResponseDto(SotCase sotCase) {
        return SotCaseResponseDto.builder()
                .id(sotCase.getId())
                .caseCode(sotCase.getCaseCode())
                .weekDate(sotCase.getWeekDate())
                .supplier(sotCase.getSupplier())
                .supplierRegion(sotCase.getSupplierRegion())
                .siteCode(sotCase.getSiteCode())
                .staVhm(sotCase.getStaVhm())
                .caseType(sotCase.getCaseType())
                .delayDays(sotCase.getDelayDays())
                .activeSite(sotCase.getActiveSite())
                .status(StatusUtil.getStatusFromDelay(sotCase.getDelayDays()))
                .build();
    }
}