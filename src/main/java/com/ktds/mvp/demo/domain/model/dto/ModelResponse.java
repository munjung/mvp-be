package com.ktds.mvp.demo.domain.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModelResponse {

    private Long id;
    @Schema(description = "모델명", example = "K3")
    private String name;


}
