package com.ktds.mvp.demo.domain.damage.mapper;

import com.ktds.mvp.demo.domain.damage.dto.DamageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DamageMapper {

    List<DamageDto> getDamageList();
}
