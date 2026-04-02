package com.ktds.mvp.demo.domain.damage.service;

import com.ktds.mvp.demo.domain.damage.dto.DamageResponse;
import com.ktds.mvp.demo.domain.damage.mapper.DamageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DamageService {

    private final DamageUtil damageUtil;
    private final DamageMapper damageMapper;

    public List<DamageResponse> getDamageList() {
        return this.damageUtil.groupByCategory(this.damageMapper.getDamageList());
    }
}
