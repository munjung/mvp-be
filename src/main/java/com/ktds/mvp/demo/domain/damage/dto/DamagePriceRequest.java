package com.ktds.mvp.demo.domain.damage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class DamagePriceRequest {
    private List<VehicleDto> ownVehicle;
    private List<VehicleDto> otherVehicle;

    @Data
    public static class VehicleDto {
        private String vehicleId;
        private String damageDegree;
        @Schema(description = "파손부위 id 목록", example = "[1,2,3]")
        private List<Long> damageParts;

        // DamagePriceRequest 전용 추가 필드
        private int mileage;      // 주행거리
        private int modelYear;    // 연식
    }
}
