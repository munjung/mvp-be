package com.ktds.mvp.demo.domain.damage.dto;

import lombok.Data;

@Data
public class DamageDto {
    private Long categoryId;
    private String categoryName;
    private Long partId;
    private String partName;
}
