package com.ktds.mvp.demo.domain.model.controller;

import com.ktds.mvp.demo.common.response.ApiResponse;
import com.ktds.mvp.demo.domain.model.dto.ModelResponse;
import com.ktds.mvp.demo.domain.model.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "차량 모델(Model)", description = "차량 모델")
@RestController
@RequestMapping("/api/v1/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @Operation(summary = "제조사 모델 목록 조회", description = "제조사에 속한 차량 모델 리스트를 조회합니다.")
    @GetMapping("/{brandId}")
    public ApiResponse<List<ModelResponse>> getModelAllList(@PathVariable("brandId") Long brandId) {
        return ApiResponse.success(this.modelService.getModelListByBrand(brandId));
    }
}
