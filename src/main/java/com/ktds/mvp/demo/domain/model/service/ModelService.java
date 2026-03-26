package com.ktds.mvp.demo.domain.model.service;


import com.ktds.mvp.demo.domain.model.dto.ModelResponse;
import com.ktds.mvp.demo.domain.model.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelMapper modelMapper;

    public List<String> getModelListByBrand(Long brandId) {
        List<ModelResponse> modelResponseList = this.modelMapper.getModelListByBrand(brandId);
        return modelResponseList.stream().map(ModelResponse::getName).distinct().toList();
    }
}
