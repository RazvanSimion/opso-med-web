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
    private Long dayOfWeek;

    @Field("open_hour")
    private LocalTime openHour;

    @Field("close_hour")
    private LocalTime closeHour;

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

    public Long getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Long dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getOpenHour() {
        return openHour;
    }

    public void setOpenHour(LocalTime openHour) {
        this.openHour = openHour;
    }

    public LocalTime getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(LocalTime closeHour) {
        this.closeHour = closeHour;
    }

    public ExpertRef getExpert() {
        return expert;
    }

    public void setExpert(ExpertRef expert) {
        this.expert = expert;
    }

    public OfficeRef getOffice() {
        return office;
    }

    public void setOffice(OfficeRef office) {
        this.office = office;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;

        Schedule schedule = (Schedule) o;

        if (id != null ? !id.equals(schedule.id) : schedule.id != null) return false;
        if (dayOfWeek != null ? !dayOfWeek.equals(schedule.dayOfWeek) : schedule.dayOfWeek != null) return false;
        if (openHour != null ? !openHour.equals(schedule.openHour) : schedule.openHour != null) return false;
        if (closeHour != null ? !closeHour.equals(schedule.closeHour) : schedule.closeHour != null) return false;
        if (expert != null ? !expert.equals(schedule.expert) : schedule.expert != null) return false;
        if (office != null ? !office.equals(schedule.office) : schedule.office != null) return false;
        if (type != null ? !type.equals(schedule.type) : schedule.type != null) return false;
        if (day != null ? !day.equals(schedule.day) : schedule.day != null) return false;
        return reason != null ? reason.equals(schedule.reason) : schedule.reason == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dayOfWeek != null ? dayOfWeek.hashCode() : 0);
        result = 31 * result + (openHour != null ? openHour.hashCode() : 0);
        result = 31 * result + (closeHour != null ? closeHour.hashCode() : 0);
        result = 31 * result + (expert != null ? expert.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Schedule{" +
            "id='" + id + '\'' +
            ", dayOfWeek=" + dayOfWeek +
            ", openHour=" + openHour +
            ", closeHour=" + closeHour +
            ", expert=" + expert +
            ", office=" + office +
            ", type=" + type +
            ", day=" + day +
            ", reason='" + reason + '\'' +
            '}';
    }
}
