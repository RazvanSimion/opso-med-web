package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
@Document(collection = "appointment")
public class Availability implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Indexed
    @Field("year")
    private int year;

    @NotNull
    @Indexed
    @Field("week_day")
    private int weekDay;

    @NotNull
    @Indexed
    @Field("start_ts")
    private LocalDateTime startTs;

    @NotNull
    @Indexed
    @Field("end_ts")
    private LocalDateTime endTs;


    @Field("appointment")
    @Indexed
    private boolean appointment;

    @Field("schedule")
    @Indexed
    private boolean schedule;

    @Field("available")
    @Indexed
    private boolean available;

    @Field("organization")
    private Organization organization;

    @Field("office")
    private OfficeRef office;

    @Field("expert")
    private ExpertRef expert;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartTs() {
        return startTs;
    }

    public void setStartTs(LocalDateTime startTs) {
        this.startTs = startTs;
    }
    public Availability startTs(LocalDateTime startTs) {
        this.startTs = startTs;return this;
    }

    public LocalDateTime getEndTs() {
        return endTs;
    }

    public void setEndTs(LocalDateTime endTs) {
        this.endTs = endTs;
    }

    public Availability endTs(LocalDateTime endTs) {
        this.endTs = endTs;return this;
    }
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Availability organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public OfficeRef getOffice() {
        return office;
    }

    public void setOffice(OfficeRef office) {
        this.office = office;
    }

    public Availability office(OfficeRef office) {
        this.office = office;
        return this;
    }

    public ExpertRef getExpert() {
        return expert;
    }

    public void setExpert(ExpertRef expert) {
        this.expert = expert;
    }

    public Availability expert(ExpertRef expert) {
        this.expert = expert;
        return this;
    }

    public boolean isAppointment() {
        return appointment;
    }

    public void setAppointment(boolean appointment) {
        this.appointment = appointment;
    }

    public Availability appointment(boolean appointment) {
        this.appointment = appointment;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Availability available(boolean available) {
        this.available = available;
        return this;
    }

    public boolean isSchedule() {
        return schedule;
    }

    public Availability schedule(boolean schedule) {
        this.schedule = schedule;
        return this;
    }

    public void setSchedule(boolean schedule) {
        this.schedule = schedule;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Availability year(int year) {
        this.year = year;
        return this;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public Availability weekDay(int weekDay) {
        this.weekDay = weekDay;
        return this;
    }
    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Availability)) return false;

        Availability that = (Availability) o;

        if (getYear() != that.getYear()) return false;
        if (getWeekDay() != that.getWeekDay()) return false;
        if (isAppointment() != that.isAppointment()) return false;
        if (isSchedule() != that.isSchedule()) return false;
        if (isAvailable() != that.isAvailable()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getStartTs() != null ? !getStartTs().equals(that.getStartTs()) : that.getStartTs() != null) return false;
        if (getEndTs() != null ? !getEndTs().equals(that.getEndTs()) : that.getEndTs() != null) return false;
        if (getOrganization() != null ? !getOrganization().equals(that.getOrganization()) : that.getOrganization() != null)
            return false;
        if (getOffice() != null ? !getOffice().equals(that.getOffice()) : that.getOffice() != null) return false;
        return getExpert() != null ? getExpert().equals(that.getExpert()) : that.getExpert() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getYear();
        result = 31 * result + getWeekDay();
        result = 31 * result + (getStartTs() != null ? getStartTs().hashCode() : 0);
        result = 31 * result + (getEndTs() != null ? getEndTs().hashCode() : 0);
        result = 31 * result + (isAppointment() ? 1 : 0);
        result = 31 * result + (isSchedule() ? 1 : 0);
        result = 31 * result + (isAvailable() ? 1 : 0);
        result = 31 * result + (getOrganization() != null ? getOrganization().hashCode() : 0);
        result = 31 * result + (getOffice() != null ? getOffice().hashCode() : 0);
        result = 31 * result + (getExpert() != null ? getExpert().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Availability{" +
            "id='" + id + '\'' +
            ", year=" + year +
            ", weekDay=" + weekDay +
            ", startTs=" + startTs +
            ", endTs=" + endTs +
            ", appointment=" + appointment +
            ", schedule=" + schedule +
            ", available=" + available +
            ", organization=" + organization +
            ", office=" + office +
            ", expert=" + expert +
            '}';
    }
}
