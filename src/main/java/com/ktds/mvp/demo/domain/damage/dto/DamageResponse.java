package com.ktds.mvp.demo.domain.damage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class DamageResponse {
    @Schema(description = "카테고리 id", example = "1")
    private Long id;
    @Schema(description = "카테고리 명", example = "전면부")
    private String category;
    @Schema(description = "카테고리별 파트", example = "전방 카메라 센서")
    private List<Part> part;

    @Data
    public static class Part {
        private Long id;
        private String name;
    }
}
