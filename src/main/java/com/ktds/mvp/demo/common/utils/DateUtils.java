package com.ktds.mvp.demo.common.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {
        // util 클래스 인스턴스 생성 방지
    }

    public static final String DEFAULT_DATE = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    private static final ZoneId ZONE_SEOUL = ZoneId.of("Asia/Seoul");

    /*
     * 현재 시간 (LocalDateTime)
     */
    public static LocalDateTime now() {
        return LocalDateTime.now(ZONE_SEOUL);
    }

    /*
     * 현재 날짜 (LocalDate)
     */
    public static LocalDate today() {
        return LocalDate.now(ZONE_SEOUL);
    }

    /*
     * 문자열 → LocalDateTime
     */
    public static LocalDateTime toDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(DEFAULT_DATETIME));
    }

    /*
     * 문자열 → LocalDate
     */
    public static LocalDate toDate(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DEFAULT_DATE));
    }

    /*
     * LocalDateTime → 문자열
     */
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME));
    }

    /*
     * LocalDate → 문자열
     */
    public static String format(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(DEFAULT_DATE));
    }

    /*
     * 날짜 더하기
     */
    public static LocalDateTime addDays(LocalDateTime dateTime, int days) {
        return dateTime.plusDays(days);
    }

    /*
     * 날짜 빼기
     */
    public static LocalDateTime minusDays(LocalDateTime dateTime, int days) {
        return dateTime.minusDays(days);
    }

    /*
     * 시작일 (00:00:00)
     */
    public static LocalDateTime startOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    /*
     * 종료일 (23:59:59)
     */
    public static LocalDateTime endOfDay(LocalDate date) {
        return date.atTime(23, 59, 59);
    }

    /*
     * 두 날짜 사이 일수 차이
     */
    public static long betweenDays(LocalDate start, LocalDate end) {
        return Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays();
    }
}
