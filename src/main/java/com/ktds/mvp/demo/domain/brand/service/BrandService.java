package com.ktds.mvp.demo.domain.brand.service;

import com.ktds.mvp.demo.common.exception.BusinessException;
import com.ktds.mvp.demo.common.exception.ErrorCode;
import com.ktds.mvp.demo.domain.brand.dto.BrandResponse;
import com.ktds.mvp.demo.domain.brand.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandMapper brandMapper;

    public List<BrandResponse> getBrandList() {
        return this.brandMapper.getBrandList();
    }
    public BrandResponse getBrand(Long id) {
        BrandResponse result = this.brandMapper.getBrandById(id);
        if (result == null) throw new BusinessException(ErrorCode.BRAND_NOT_FOUND);
        return result;
    }

}
