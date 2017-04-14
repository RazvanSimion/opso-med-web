package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private int dayOfWeek;

    @Field("start_hour")
    private LocalTime startHour;

    @Field("end_hour")
    private LocalTime endHour;

    @Field("expert")
    private ExpertRef expert;

    @Field("office")
    private OfficeRef office;
    /**
     * -1 - Closed - O exceptie: O zi speciala de exemplu din saptamana in care nu se lucreaza. De exemplu luni, 24 ianuarie 2017 nu se lucreaza.
     * 0 - dayOfWeek
     * 1 - Opened - O exceptie: O zi speciala de exemplu de weekend in care se lucreaza
     */
    @Field("type")
    private Long type;

    @Field("day")
    private LocalDate day;

    @Size(max = 1000)
    @Field("reason")
    private String reason;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Schedule dayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public Schedule setStartHour(LocalTime startHour) {
        this.startHour = startHour;
        return this;
    }

    public Schedule startHour(LocalTime startHour) {
        this.startHour = startHour;
        return this;
    }


    public LocalTime getEndHour() {
        return endHour;
    }

    public Schedule setEndHour(LocalTime endHour) {
        this.endHour = endHour;
        return this;
    }

    public Schedule endHour(LocalTime endHour) {
        this.endHour = endHour;
        return this;
    }

    public ExpertRef getExpert() {
        return expert;
    }

    public void setExpert(ExpertRef expert) {
        this.expert = expert;
    }

    public Schedule expert(ExpertRef expert) {
        this.expert = expert;
        return this;
    }

    public OfficeRef getOffice() {
        return office;
    }

    public void setOffice(OfficeRef office) {
        this.office = office;
    }

    public Schedule office(OfficeRef office) {
        this.office = office;
        return this;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Schedule type(Long type) {
        this.type = type;
        return this;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Schedule day(LocalDate day) {
        this.day = day;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Schedule reason(String reason) {
        this.reason = reason;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;

        Schedule schedule = (Schedule) o;

        if (getDayOfWeek() != schedule.getDayOfWeek()) return false;
        if (getId() != null ? !getId().equals(schedule.getId()) : schedule.getId() != null) return false;
        if (getStartHour() != null ? !getStartHour().equals(schedule.getStartHour()) : schedule.getStartHour() != null)
            return false;
        if (getEndHour() != null ? !getEndHour().equals(schedule.getEndHour()) : schedule.getEndHour() != null)
            return false;
        if (getExpert() != null ? !getExpert().equals(schedule.getExpert()) : schedule.getExpert() != null)
            return false;
        if (getOffice() != null ? !getOffice().equals(schedule.getOffice()) : schedule.getOffice() != null)
            return false;
        if (getType() != null ? !getType().equals(schedule.getType()) : schedule.getType() != null) return false;
        if (getDay() != null ? !getDay().equals(schedule.getDay()) : schedule.getDay() != null) return false;
        return getReason() != null ? getReason().equals(schedule.getReason()) : schedule.getReason() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getDayOfWeek();
        result = 31 * result + (getStartHour() != null ? getStartHour().hashCode() : 0);
        result = 31 * result + (getEndHour() != null ? getEndHour().hashCode() : 0);
        result = 31 * result + (getExpert() != null ? getExpert().hashCode() : 0);
        result = 31 * result + (getOffice() != null ? getOffice().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDay() != null ? getDay().hashCode() : 0);
        result = 31 * result + (getReason() != null ? getReason().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Schedule{" +
            "id='" + id + '\'' +
            ", dayOfWeek=" + dayOfWeek +
            ", startHour=" + startHour +
            ", endHour=" + endHour +
            ", expert=" + expert +
            ", office=" + office +
            ", type=" + type +
            ", day=" + day +
            ", reason='" + reason + '\'' +
            '}';
    }
}
