package com.ktds.mvp.demo.domain.usecase.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UseCaseVehicleDto {
    private String vehicleId;
    private String vehicleType;
    private String fuelType;
    private String engineCc;
    private Long price;
    private Brand brand;
    private Model model;

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
