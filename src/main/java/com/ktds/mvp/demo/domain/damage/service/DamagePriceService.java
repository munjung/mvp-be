package com.ktds.mvp.demo.domain.damage.service;

import com.ktds.mvp.demo.domain.damage.dto.DamagePriceRequest;
import com.ktds.mvp.demo.domain.damage.dto.DamagePriceResponse;
import com.ktds.mvp.demo.domain.damage.dto.DamagePriceVehicleDto;
import com.ktds.mvp.demo.domain.damage.mapper.DamagePriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DamagePriceService {

    private final DamagePriceMapper damagePriceMapper;

    public DamagePriceResponse getDamagePrice(DamagePriceRequest request) {
        return DamagePriceResponse.builder()
                .ownVehicle(mapVehicleList(request.getOwnVehicle()))
                .otherVehicle(mapVehicleList(request.getOtherVehicle()))
                .build();
    }

    private List<DamagePriceVehicleDto> mapVehicleList(List<DamagePriceRequest.VehicleDto> vehicles) {
        return vehicles.stream()
                .map(v -> {
                    List<DamagePriceVehicleDto.RawDto> rawList = this.damagePriceMapper.getDamagePrice(
                            v.getVehicleId(),
                            v.getDamageDegree(),
                            v.getDamageParts()
                    );
                    DamagePriceVehicleDto dto = new DamagePriceVehicleDto();
                    dto.setVehicleId(v.getVehicleId());
                    dto.setDamageParts(groupDamagePrice(rawList));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private List<DamagePriceVehicleDto.DamagePriceGroupDto> groupDamagePrice(
            List<DamagePriceVehicleDto.RawDto> rawList) {
        return rawList.stream()
                .collect(Collectors.groupingBy(
                        DamagePriceVehicleDto.RawDto::getCategoryId,
                        LinkedHashMap::new,
                        Collectors.toList()
                ))
                .entrySet().stream()
                .map(entry -> {
                    DamagePriceVehicleDto.DamagePriceGroupDto group = new DamagePriceVehicleDto.DamagePriceGroupDto();
                    group.setId(entry.getKey());
                    group.setCategory(entry.getValue().get(0).getCategory());
                    group.setPart(entry.getValue().stream()
                            .map(r -> {
                                DamagePriceVehicleDto.PriceDto price = new DamagePriceVehicleDto.PriceDto();
                                price.setDamageDegree(r.getDamageDegree());
                                price.setPartsCost(r.getPartsCost());
                                price.setLaborCost(r.getLaborCost());
                                price.setPaintCost(r.getPaintCost());

                                DamagePriceVehicleDto.PartDto part = new DamagePriceVehicleDto.PartDto();
                                part.setId(r.getPartId());
                                part.setName(r.getPartName());
                                part.setPrice(price);
                                return part;
                            })
                            .collect(Collectors.toList()));;
                    return group;
                })
                .collect(Collectors.toList());
    }
}
