package com.ktds.mvp.demo.domain.damage.controller;

import com.ktds.mvp.demo.common.response.ApiResponse;
import com.ktds.mvp.demo.domain.damage.dto.DamagePriceRequest;
import com.ktds.mvp.demo.domain.damage.dto.DamagePriceResponse;
import com.ktds.mvp.demo.domain.damage.dto.DamageResponse;
import com.ktds.mvp.demo.domain.damage.service.DamagePriceService;
import com.ktds.mvp.demo.domain.damage.service.DamageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "파손 부위(Damage)", description = "파손 부위")
@RestController
@RequestMapping("/api/v1/damage")
@RequiredArgsConstructor
public class DamageController {

    private final DamageService damageService;
    private final DamagePriceService damagePriceService;

    @Operation(summary = "파손 부위 목록 조회", description = "파손 부위 마스터 목록을 조회합니다.")
    @GetMapping
    public ApiResponse<List<DamageResponse>> getDamageList() {
        return ApiResponse.success(this.damageService.getDamageList());
    }

    @Operation(summary = "파손 가격 계산", description = "파손 부위 및 파손 정도에 따른 수리 가격을 계산합니다.")
    @PostMapping("/price")
    public ApiResponse<DamagePriceResponse> getDamagePrice(@RequestBody DamagePriceRequest request) {
        return ApiResponse.success(this.damagePriceService.getDamagePrice(request));
    }

}
