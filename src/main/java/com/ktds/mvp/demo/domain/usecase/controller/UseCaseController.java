package com.ktds.mvp.demo.domain.usecase.controller;

import com.ktds.mvp.demo.common.response.ApiResponse;
import com.ktds.mvp.demo.domain.usecase.dto.UseCaseResponse;
import com.ktds.mvp.demo.domain.usecase.dto.UseCaseVehicleResponse;
import com.ktds.mvp.demo.domain.usecase.service.UseCaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "시나리오(Use Case)", description = "시연용 유스케이스")
@RestController
@RequestMapping("/api/v1/usecase")
@RequiredArgsConstructor
public class UseCaseController {

    private final UseCaseService useCaseService;

    @Operation(summary = "UseCase 목록 조회", description = "유스케이스 리스트를 조회합니다.")
    @GetMapping
    public ApiResponse<List<UseCaseResponse>> getUseCaseList() {
        return ApiResponse.success(this.useCaseService.getUseCaseList());
    }

    @Operation(summary = "UseCase 상세 조회", description = "유스케이스 상세 내용을 조회합니다.")
    @GetMapping("/{id}")
    public ApiResponse<UseCaseVehicleResponse> getUseCaseById(@PathVariable("id") Long useCaseId) {
        return ApiResponse.success(this.useCaseService.getUseCaseById(useCaseId));
    }


}
