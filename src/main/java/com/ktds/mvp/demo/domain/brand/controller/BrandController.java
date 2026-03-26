package com.ktds.mvp.demo.domain.brand.controller;

import com.ktds.mvp.demo.domain.brand.dto.BrandResponse;
import com.ktds.mvp.demo.domain.brand.service.BrandService;
import com.ktds.mvp.demo.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "차량 제조사(Brand)", description = "제조사")
@RestController
@RequestMapping("/api/v1/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @Operation(summary = "제조사 목록 조회", description = "차량 제조사 리스트를 조회합니다.")
    @GetMapping
    public ApiResponse<List<BrandResponse>> getBrandAllList() {
        return ApiResponse.success(this.brandService.getBrandList());
    }

    @Operation(summary = "제조사 상세 조회", description = "차량 제조사 상세 내용을 조회합니다.")
    @GetMapping("/{id}")
    public ApiResponse<BrandResponse> getBrandById(@PathVariable("id") Long id) {
        return ApiResponse.success(this.brandService.getBrand(id));
    }
 }
