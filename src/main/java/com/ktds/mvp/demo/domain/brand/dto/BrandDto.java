package com.ktds.mvp.demo.domain.brand.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BrandDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Response {
        private Long id;
        private String name;
    }
}
