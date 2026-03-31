package com.ktds.mvp.demo.domain.rule.controller;

import com.ktds.mvp.demo.common.response.ApiResponse;
import com.ktds.mvp.demo.domain.rule.service.RuleEngineService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/rules")
@RequiredArgsConstructor
public class RuleEngineController {

    private final RuleEngineService ruleEngineService;

    @PostMapping("/execute")
    public ResponseEntity<ApiResponse<Object>> execute(@RequestBody Map<String, Object> ctx) {
        Object result = ruleEngineService.execute(ctx);
        return ResponseEntity.ok(ApiResponse.success(result));
    }
}
