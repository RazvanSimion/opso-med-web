package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
@Document(collection = "schedule")
public class Schedule {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("day_of_week")
    private Long dayOfWeek;

    @Field("open_hour")
    private Long openHour;

    @Field("close_hour")
    private Long closeHour;

    /**
     * -1 - Closed - O exceptie: O zi speciala de exemplu din saptamana in care nu se lucreaza. De exemplu luni, 24 ianuarie 2017 nu se lucreaza.
     * 0 - dayOfWeek
     * 1 - Opened - O exceptie: O zi speciala de exemplu de weekend in care se lucreaza
     */
    @Field("type")
    private Long type;

    @Field("day")
    private ZonedDateTime day;

    @Size(max = 250)
    @Field("reason")
    private String reason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Long dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Long getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Long openHour) {
        this.openHour = openHour;
    }

    public Long getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Long closeHour) {
        this.closeHour = closeHour;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public ZonedDateTime getDay() {
        return day;
    }

    public void setDay(ZonedDateTime day) {
        this.day = day;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Schedule{" +
            "id='" + id + '\'' +
            ", dayOfWeek=" + dayOfWeek +
            ", openHour=" + openHour +
            ", closeHour=" + closeHour +
            ", type=" + type +
            ", day=" + day +
            ", reason='" + reason + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;

        Schedule schedule = (Schedule) o;

        if (getId() != null ? !getId().equals(schedule.getId()) : schedule.getId() != null) return false;
        if (getDayOfWeek() != null ? !getDayOfWeek().equals(schedule.getDayOfWeek()) : schedule.getDayOfWeek() != null)
            return false;
        if (getOpenHour() != null ? !getOpenHour().equals(schedule.getOpenHour()) : schedule.getOpenHour() != null)
            return false;
        if (getCloseHour() != null ? !getCloseHour().equals(schedule.getCloseHour()) : schedule.getCloseHour() != null)
            return false;
        if (getType() != null ? !getType().equals(schedule.getType()) : schedule.getType() != null) return false;
        if (getDay() != null ? !getDay().equals(schedule.getDay()) : schedule.getDay() != null) return false;
        return getReason() != null ? getReason().equals(schedule.getReason()) : schedule.getReason() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDayOfWeek() != null ? getDayOfWeek().hashCode() : 0);
        result = 31 * result + (getOpenHour() != null ? getOpenHour().hashCode() : 0);
        result = 31 * result + (getCloseHour() != null ? getCloseHour().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDay() != null ? getDay().hashCode() : 0);
        result = 31 * result + (getReason() != null ? getReason().hashCode() : 0);
        return result;
    }
}
