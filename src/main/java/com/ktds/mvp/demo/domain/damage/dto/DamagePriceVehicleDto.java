package com.ktds.mvp.demo.domain.damage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class DamagePriceVehicleDto {
    private String vehicleId;
    private List<DamagePriceGroupDto> damageParts;

    // MyBatis 매핑용 (flat)
    @JsonIgnore
    private List<RawDto> rawList;

    @Data
    public static class RawDto {
        private Long categoryId;
        private String category;
        private Long partId;
        private String partName;
        private String damageDegree;
        private Long partsCost;
        private Long laborCost;
        private Long paintCost;
    }

    @Data
    public static class DamagePriceGroupDto {
        private Long id;
        private String category;
        private List<PartDto> part;
    }

    @Data
    public static class PartDto {
        private Long id;
        private String name;
        private PriceDto price;
    }

    @Data
    public static class PriceDto {
        private String damageDegree;
        private Long partsCost;
        private Long laborCost;
        private Long paintCost;
    }
}
