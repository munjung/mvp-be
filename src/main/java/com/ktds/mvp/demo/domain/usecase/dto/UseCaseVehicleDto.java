package com.ktds.mvp.demo.domain.usecase.dto;

import com.ktds.mvp.demo.domain.damage.dto.DamagePartDto;
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
    private List<DamagePartDto> damageParts;

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
