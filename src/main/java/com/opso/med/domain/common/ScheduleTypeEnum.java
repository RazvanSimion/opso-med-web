package com.opso.med.domain.common;

/**
 * Created by Razvan.Simion on 4/13/2017.
 */
public enum ScheduleTypeEnum {
    CLOSED(1L),
    DAY_OF_WEEK(0L),
    OPENED(-1L);

    private final Long code;

    ScheduleTypeEnum(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }
}
