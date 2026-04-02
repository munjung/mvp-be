package com.ktds.mvp.demo.domain.accident.mapper;

import com.ktds.mvp.demo.domain.accident.dto.AccidentResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccidentMapper {
    List<AccidentResponse> getAccidentList();
}
