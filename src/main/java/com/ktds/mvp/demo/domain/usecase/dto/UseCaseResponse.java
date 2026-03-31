package com.ktds.mvp.demo.domain.usecase.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UseCaseResponse {
    private Long id;
    @Schema(description = "use case", example = "Case1: 교차로 골목길 충돌 - 그랜져 vs BMW 7시리즈")
    private String name;
}
