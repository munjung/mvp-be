package com.ktds.mvp.demo.domain.accident.service;

import com.ktds.mvp.demo.domain.accident.dto.AccidentResponse;
import com.ktds.mvp.demo.domain.accident.mapper.AccidentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentService {
    private final AccidentMapper accidentMapper;

    public List<AccidentResponse> getAccidentList() {
        return this.accidentMapper.getAccidentList();
    }
}
