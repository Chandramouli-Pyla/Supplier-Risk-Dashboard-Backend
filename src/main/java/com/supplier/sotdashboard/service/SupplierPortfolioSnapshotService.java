package com.supplier.sotdashboard.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplier.sotdashboard.dto.SupplierPortfolioSnapshotResponseDto;
import com.supplier.sotdashboard.entity.SupplierPortfolioSnapshot;
import com.supplier.sotdashboard.repository.SupplierPortfolioSnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class SupplierPortfolioSnapshotService {

    private final SupplierPortfolioSnapshotRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public SupplierPortfolioSnapshotService(SupplierPortfolioSnapshotRepository repository) {
        this.repository = repository;
    }

    public List<SupplierPortfolioSnapshotResponseDto> getAllSnapshots() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private SupplierPortfolioSnapshotResponseDto mapToDto(SupplierPortfolioSnapshot entity) {
        return SupplierPortfolioSnapshotResponseDto.builder()
                .id(entity.getId())
                .siteCode(entity.getSiteCode())
                .supplier(entity.getSupplier())
                .address(entity.getAddress())
                .country(entity.getCountry())
                .postalCode(entity.getPostalCode())
                .segmentStatus(entity.getSegmentStatus())
                .supplierRegion(entity.getSupplierRegion())
                .q1Status(entity.getQ1Status())
                .q1Score(entity.getQ1Score())
                .siteSegmentRows(parseList(entity.getSiteSegmentRowsJson()))
                .ppap(parseObject(entity.getPpapJson()))
                .commercialDate(entity.getCommercialDate())
                .commercialDistress(entity.getCommercialDistress())
                .commercialFhr(entity.getCommercialFhr())
                .tvm(parseObject(entity.getTvmJson()))
                .behindSched(parseObject(entity.getBehindSchedJson()))
                .dpr(parseObject(entity.getDprJson()))
                .premiumFreight(parseObject(entity.getPremiumFreightJson()))
                .vor(parseObject(entity.getVorJson()))
                .wers(parseObject(entity.getWersJson()))
                .srea(parseObject(entity.getSreaJson()))
                .ecarOee(parseObject(entity.getEcarOeeJson()))
                .fcsdBacklog(parseObject(entity.getFcsdBacklogJson()))
                .msa(parseObject(entity.getMsaJson()))
                .systemicKpi(entity.getSystemicKpi())
                .behindKpi(entity.getBehindKpi())
                .demandKpi(entity.getDemandKpi())
                .releaseVsRequired(parseList(entity.getReleaseVsRequiredJson()))
                .sotBreakdown(parseObject(entity.getSotBreakdownJson()))
                .plantBreakdown(parseObject(entity.getPlantBreakdownJson()))
                .trendChart(parseList(entity.getTrendChartJson()))
                .summaryRow1(parseObject(entity.getSummaryRow1Json()))
                .summaryRow2(parseObject(entity.getSummaryRow2Json()))
                .summaryRow3(parseObject(entity.getSummaryRow3Json()))
                .productPortfolio(parseObject(entity.getProductPortfolioJson()))
                .build();
    }

    private Map<String, Object> parseObject(String json) {
        try {
            if (json == null || json.isBlank()) {
                return Collections.emptyMap();
            }
            return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON object", e);
        }
    }

    private List<Map<String, Object>> parseList(String json) {
        try {
            if (json == null || json.isBlank()) {
                return Collections.emptyList();
            }
            return objectMapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON list", e);
        }
    }
}