package com.ktds.mvp.demo.domain.model.mapper;

import com.ktds.mvp.demo.domain.model.dto.ModelResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModelMapper {
    List<ModelResponse> getModelListByBrand(Long brandId);
}
