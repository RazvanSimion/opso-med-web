package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
@Document(collection = "job")
public class Job {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("office")
    private Office office;

    @Field("schedules")
    private Set<Schedule> schedules;

    @Field("services")
    private Set<JobService> services;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Job office(Office office) {
        this.office = office;
        return this;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Job schedules(Set<Schedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    public Set<JobService> getServices() {
        return services;
    }

    public Job setServices(Set<JobService> services) {
        this.services = services;
        return this;
    }

    public Job services(Set<JobService> services) {
        this.services = services;
        return this;
    }

    @Override
    public String toString() {
        return "Job{" +
            "id='" + id + '\'' +
            ", office=" + office +
            ", schedules=" + schedules +
            ", services=" + services +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;

        Job job = (Job) o;

        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        if (office != null ? !office.equals(job.office) : job.office != null) return false;
        if (schedules != null ? !schedules.equals(job.schedules) : job.schedules != null) return false;
        return services != null ? services.equals(job.services) : job.services == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (schedules != null ? schedules.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        return result;
    }
}
