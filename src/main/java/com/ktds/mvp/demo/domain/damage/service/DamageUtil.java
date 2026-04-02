package com.ktds.mvp.demo.domain.damage.service;

import com.ktds.mvp.demo.domain.damage.dto.DamageDto;
import com.ktds.mvp.demo.domain.damage.dto.DamageResponse;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DamageUtil {

    // List<DamageDto>를 그룹핑
    public List<DamageResponse> groupByCategory(List<DamageDto> damageDtos) {
        return damageDtos.stream()
                .collect(Collectors.groupingBy(DamageDto::getCategoryId, LinkedHashMap::new, Collectors.toList()))
                .entrySet().stream()
                .map(entry -> {
                    DamageResponse dto = new DamageResponse();
                    dto.setId(entry.getKey());
                    dto.setCategory(entry.getValue().get(0).getCategoryName());
                    dto.setPart(entry.getValue().stream()
                            .map(p -> {
                                DamageResponse.Part part = new DamageResponse.Part();
                                part.setId(p.getPartId());
                                part.setName(p.getPartName());
                                return part;
                            }).toList());
                    return dto;
                }).toList();
    }
}
