package com.ktds.mvp.demo.common.utils;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    /*
     * null 또는 공백 체크
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /*
     * null, 공백 아닌 경우
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /*
     * 기본값 처리 (null이면 default 반환)
     */
    public static String defaultString(String str, String defaultValue) {
        return str == null ? defaultValue : str;
    }

    /*
     * 좌우 공백 제거 (null-safe)
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /*
     * 문자열 길이 제한 (초과 시 자르기)
     */
    public static String truncate(String str, int maxLength) {
        if (str == null) return null;
        if (str.length() <= maxLength) return str;
        return str.substring(0, maxLength);
    }

    /*
     * 숫자인지 체크
     */
    public static boolean isNumeric(String str) {
        if (isEmpty(str)) return false;
        return str.chars().allMatch(Character::isDigit);
    }

    /*
     * 문자열 비교 (null-safe)
     */
    public static boolean equals(String a, String b) {
        if (a == null) return b == null;
        return a.equals(b);
    }

    /*
     * 포함 여부 (null-safe)
     */
    public static boolean contains(String str, String keyword) {
        if (str == null || keyword == null) return false;
        return str.contains(keyword);
    }

    /*
     * 대문자 변환 (null-safe)
     */
    public static String upper(String str) {
        return str == null ? null : str.toUpperCase();
    }

    /*
     * 소문자 변환 (null-safe)
     */
    public static String lower(String str) {
        return str == null ? null : str.toLowerCase();
    }
}
