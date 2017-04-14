package com.opso.med.domain.common;

/**
 * Created by Razvan.Simion on 4/13/2017.
 */
public enum InvestigationStatusEnum {
    FINISHED(1L),
    IN_PROGRESS(0L),
    CANCELED(-1L);

    private final Long code;

    InvestigationStatusEnum(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }
}
