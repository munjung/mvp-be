package com.ktds.mvp.demo.domain.usecase.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class UseCaseVehicleResponse {
    private List<UseCaseVehicleDto> ownVehicle;
    private List<UseCaseVehicleDto> otherVehicle;
}
