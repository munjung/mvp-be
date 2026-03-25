package com.ktds.mvp.demo.common.paging;

import java.util.List;

public class PageUtils {

    private PageUtils() {}

    public static <T> PageResponse<T> of(List<T> content, PageRequest request, long totalCount) {

        int totalPages = (int) Math.ceil((double) totalCount / request.getSize());

        return PageResponse.<T>builder()
                .content(content)
                .page(request.getPage())
                .size(request.getSize())
                .totalCount(totalCount)
                .totalPages(totalPages)
                .hasNext(request.getPage() < totalPages)
                .build();
    }
}