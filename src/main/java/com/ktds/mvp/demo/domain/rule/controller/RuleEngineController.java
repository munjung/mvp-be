package com.ktds.mvp.demo.domain.rule.controller;

import com.ktds.mvp.demo.common.response.ApiResponse;
import com.ktds.mvp.demo.domain.rule.service.RuleEngineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "온톨로지 규칙 실행(Rule Execute)", description = "규칙 실행 서버")
@RestController
@RequestMapping("/api/v1/rules")
@RequiredArgsConstructor
public class RuleEngineController {

    private final RuleEngineService ruleEngineService;

    @Operation(summary = "규칙 실행", description = "R01~R49")
    @PostMapping("/execute")
    public ApiResponse<Object> execute(@RequestBody Map<String, Object> ctx) {
        return ApiResponse.success(this.ruleEngineService.execute(ctx));
    }
}
