package com.ktds.mvp.demo.domain.rule.service;

import com.ktds.mvp.demo.common.client.ApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RuleEngineService {

    private final ApiClient apiClient;
    @Value("${rule-engine.url}")
    private String ruleEngineUrl;

    public Object execute(Map<String, Object> ctx) {
        return apiClient.post(ruleEngineUrl+ "/execute", Map.of("ctx", ctx), Object.class);
    }
}
