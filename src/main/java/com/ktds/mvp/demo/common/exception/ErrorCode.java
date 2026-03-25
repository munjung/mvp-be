package com.ktds.mvp.demo.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 공통
    BAD_REQUEST("400", "잘못된 요청입니다."),
    NOT_FOUND("404", "데이터를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR("500", "서버 오류가 발생했습니다."),

    // Brand
    BRAND_NOT_FOUND("B001", "브랜드를 찾을 수 없습니다."),
    BRAND_ALREADY_EXISTS("B002", "이미 존재하는 브랜드입니다.");

    // 기능 추가 시 여기에 추가
    // PRODUCT_NOT_FOUND("P001", "상품을 찾을 수 없습니다."),

    private final String code;
    private final String message;
}
