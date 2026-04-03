package com.ktds.mvp.demo.domain.damage.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DamagePriceResponse {
    private List<DamagePriceVehicleDto> ownVehicle;
    private List<DamagePriceVehicleDto> otherVehicle;
}
