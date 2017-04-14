package com.opso.med.domain.common;

/**
 * Created by Razvan.Simion on 4/13/2017.
 */
public enum InvestigationTypeEnum {
    OPERATION("OPERATION"),
    PRESCRIPTION("PRESCRIPTION"),
    ANALYSIS("ANALYSIS"),
    RADIOGRAM("RADIOGRAM");

    private final String code;

    InvestigationTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
