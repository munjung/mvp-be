package com.ktds.mvp.demo.domain.brand.mapper;

import com.ktds.mvp.demo.domain.brand.dto.BrandResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {

    List<BrandResponse> getBrandList();

    BrandResponse getBrandById(Long id);
}
