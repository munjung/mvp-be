package com.ktds.mvp.demo.domain.accident.controller;

import com.ktds.mvp.demo.domain.accident.dto.AccidentResponse;
import com.ktds.mvp.demo.common.response.ApiResponse;
import com.ktds.mvp.demo.domain.accident.service.AccidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "사고 유형 (Accident)", description = "사고유형")
@RestController
@RequestMapping("/api/v1/accident")
@RequiredArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;

    @Operation(summary = "사고유형 목록 조회", description = "사고유형 리스트를 조회합니다.")
    @GetMapping
    public ApiResponse<List<AccidentResponse>> getAccidentList (){
        return ApiResponse.success(this.accidentService.getAccidentList());
    }
}
