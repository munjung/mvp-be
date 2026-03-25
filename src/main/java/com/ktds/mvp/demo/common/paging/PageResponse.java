package com.ktds.mvp.demo.common.paging;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageResponse<T> {

    private List<T> content;   // 데이터 리스트
    private int page;          // 현재 페이지
    private int size;          // 페이지 사이즈
    private long totalCount;   // 전체 데이터 수
    private int totalPages;    // 전체 페이지 수
    private boolean hasNext;   // 다음 페이지 여부
}
