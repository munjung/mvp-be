package com.ktds.mvp.demo.domain.usecase.mapper;

import com.ktds.mvp.demo.domain.usecase.dto.UseCaseResponse;
import com.ktds.mvp.demo.domain.usecase.dto.UseCaseVehicleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UseCaseMapper {
    List<UseCaseResponse> getUseCaseList();
    List<UseCaseVehicleDto> getUseCaseById(Long useCaseId);
}
