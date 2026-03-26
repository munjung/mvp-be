package com.ktds.mvp.demo.domain.damage.service;

import com.ktds.mvp.demo.domain.damage.dto.DamageDto;
import com.ktds.mvp.demo.domain.damage.dto.DamageResponse;
import com.ktds.mvp.demo.domain.damage.mapper.DamageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DamageService {
    private final DamageMapper damageMapper;

    public List<DamageResponse> getDamageList() {
        List<DamageDto> damageDtos = this.damageMapper.getDamageList();
        return damageDtos.stream().collect(Collectors.groupingBy(DamageDto::getCategoryId))
                .values().stream()
                .map(group -> {

                    DamageResponse dto = new DamageResponse();
                    dto.setId(group.get(0).getCategoryId());
                    dto.setCategory(group.get(0).getCategoryName());

                    List<DamageResponse.Part> parts = group.stream()
                            .map(part -> {
                                DamageResponse.Part p = new DamageResponse.Part();
                                p.setId(part.getPartId());
                                p.setName(part.getPartName());
                                return p;
                            }).toList();

                    dto.setPart(parts);
                    return dto;
                }).toList();
    }
}
