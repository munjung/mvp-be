package com.ktds.mvp.demo.domain.damage.mapper;

import com.ktds.mvp.demo.domain.damage.dto.DamagePriceVehicleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DamagePriceMapper {
    List<DamagePriceVehicleDto.RawDto> getDamagePrice(
            @Param("vehicleId") String vehicleId,
            @Param("damageDegree") String damageDegree,
            @Param("damageParts") List<Long> damageParts
    );
}
