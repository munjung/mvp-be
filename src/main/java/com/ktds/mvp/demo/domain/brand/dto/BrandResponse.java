package com.ktds.mvp.demo.domain.brand.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrandResponse {

    private Long id;
    @Schema(description = "제조사", example = "현대")
    private String name;
    @Schema(description = "원산지", example = "국산")
    private String origin;
}
