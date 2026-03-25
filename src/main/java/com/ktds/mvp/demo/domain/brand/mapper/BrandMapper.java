package com.ktds.mvp.demo.domain.brand.mapper;

import com.ktds.mvp.demo.domain.brand.dto.BrandDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {

    List<BrandDto.Response> getBrandList();

    BrandDto.Response getBrandById(Long id);
}
