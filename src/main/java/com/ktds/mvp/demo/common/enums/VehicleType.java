package com.ktds.mvp.demo.common.enums;

import lombok.Getter;

@Getter
public enum VehicleType {
    OWN("자사"),
    OTHER("타사");

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

}
