package com.ktds.mvp.demo.common.exception;

import com.ktds.mvp.demo.common.response.ApiResponse;
import com.ktds.mvp.demo.common.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 비즈니스 예외 (ErrorCode 기반)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public ApiResponse<?> handleBusinessException(BusinessException e) {
        log.warn("BusinessException: [{}] {}", e.getErrorCode().getCode(), e.getMessage());
        return ApiResponse.fail(e.getErrorCode().getCode(), e.getErrorCode().getMessage());
    }

    // 데이터 없음
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NoSuchElementException.class)
    public ApiResponse<?> handleNoSuchElementException(NoSuchElementException e) {
        log.warn("NoSuchElementException: {}", e.getMessage());
        return ApiResponse.fail(ResponseCode.NOT_FOUND);
    }

    // 잘못된 요청 (Request 유효성 검사 실패)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("MethodArgumentNotValidException: {}", e.getMessage());
        return ApiResponse.fail(ResponseCode.BAD_REQUEST);
    }

    // 잘못된 인자
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse<?> handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("IllegalArgumentException: {}", e.getMessage());
        return ApiResponse.fail(ResponseCode.BAD_REQUEST);
    }

    // 그 외 서버 오류
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception e) {
        log.error("Exception: {}", e.getMessage(), e);
        return ApiResponse.fail(ResponseCode.INTERNAL_SERVER_ERROR);
    }
}
