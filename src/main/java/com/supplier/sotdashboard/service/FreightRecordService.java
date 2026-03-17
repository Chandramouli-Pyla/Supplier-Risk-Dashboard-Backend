package com.supplier.sotdashboard.service;

import com.supplier.sotdashboard.dto.FreightRecordResponseDto;
import com.supplier.sotdashboard.entity.FreightRecord;
import com.supplier.sotdashboard.repository.FreightRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreightRecordService {

    private final FreightRecordRepository freightRecordRepository;

    public FreightRecordService(FreightRecordRepository freightRecordRepository) {
        this.freightRecordRepository = freightRecordRepository;
    }

    public List<FreightRecordResponseDto> getAllFreightRecords() {
        return freightRecordRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private FreightRecordResponseDto mapToDto(FreightRecord freightRecord) {
        return FreightRecordResponseDto.builder()
                .id(freightRecord.getId())
                .recordCode(freightRecord.getRecordCode())
                .vhm(freightRecord.getVhm())
                .siteCode(freightRecord.getSiteCode())
                .siteName(freightRecord.getSiteName())
                .partNumber(freightRecord.getPartNumber())
                .freightMonth(freightRecord.getFreightMonth())
                .dprMonth(freightRecord.getDprMonth())
                .shipYear(freightRecord.getShipYear())
                .qty(freightRecord.getQty())
                .totalAmount(freightRecord.getTotalAmount())
                .build();
    }
}