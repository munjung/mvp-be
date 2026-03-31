package com.ktds.mvp.demo.domain.usecase.service;

import com.ktds.mvp.demo.common.enums.VehicleType;
import com.ktds.mvp.demo.domain.usecase.dto.UseCaseResponse;
import com.ktds.mvp.demo.domain.usecase.dto.UseCaseVehicleDto;
import com.ktds.mvp.demo.domain.usecase.dto.UseCaseVehicleResponse;
import com.ktds.mvp.demo.domain.usecase.mapper.UseCaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UseCaseService {

    private final UseCaseMapper useCaseMapper;

    public List<UseCaseResponse> getUseCaseList() {
        return this.useCaseMapper.getUseCaseList();
    }

    public UseCaseVehicleResponse getUseCaseById(Long useCaseId) {
        List<UseCaseVehicleDto> useCaseVehicleDtos = this.useCaseMapper.getUseCaseById(useCaseId);
        return UseCaseVehicleResponse.builder()
                .ownVehicle(useCaseVehicleDtos.stream().filter(v -> VehicleType.OWN.getValue().equals(v.getVehicleType())).collect(Collectors.toList()))
                .otherVehicle(useCaseVehicleDtos.stream().filter(v -> VehicleType.OTHER.getValue().equals(v.getVehicleType())).collect(Collectors.toList()))
                .build();
    }
}
