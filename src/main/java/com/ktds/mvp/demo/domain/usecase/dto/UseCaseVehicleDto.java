package com.ktds.mvp.demo.domain.usecase.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ktds.mvp.demo.domain.damage.dto.DamageDto;
import com.ktds.mvp.demo.domain.damage.dto.DamageResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class UseCaseVehicleDto {
    private String vehicleId;
    private String vehicleType;
    private String damageDegree;
    private String fuelType;
    private String engineCc;
    private Long price;
    private Brand brand;
    private Model model;
    private List<DamageResponse> damageParts;
    @JsonIgnore
    private List<DamageDto> rawDamageParts;

    @NoArgsConstructor
    @Data
    public static class Brand {
        private Long id;
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class Model {
        private Long id;
        private String name;
        private String generation;
    }
}
