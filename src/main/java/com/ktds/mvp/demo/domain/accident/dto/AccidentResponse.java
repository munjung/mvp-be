package com.ktds.mvp.demo.domain.accident.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccidentResponse {
    private Long id;
    @Schema(description = "사고유형", example = "후미추돌 - 직진 중 추돌")
    private String type_name;
}
