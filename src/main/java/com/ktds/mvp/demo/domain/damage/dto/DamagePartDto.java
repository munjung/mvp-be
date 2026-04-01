package com.ktds.mvp.demo.domain.damage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DamagePartDto {
    @JsonIgnore
    private Long useCaseVehicleId;
    private String category;
    private String name;
}
