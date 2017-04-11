package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
@Document(collection = "office")
public class Office {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Indexed
    @Size(max = 250)
    @Field("name")
    private String name;

    @Size(max = 1000)
    @Field("description")
    private String description;

    @NotNull
    @Field("position")
    @GeoSpatialIndexed
    private double[] position;

    @Field("contacts")
    private Set<Contact> contacts;

    @Field("schedules")
    private Set<Schedule> schedules;

    @Field("organization")
    private Organization organization;


    @Override
    public String toString() {
        return "Office{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", position=" + Arrays.toString(position) +
            ", contacts=" + contacts +
            ", schedules=" + schedules +
            ", organization=" + organization +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Office)) return false;

        Office office = (Office) o;

        if (getId() != null ? !getId().equals(office.getId()) : office.getId() != null) return false;
        if (getName() != null ? !getName().equals(office.getName()) : office.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(office.getDescription()) : office.getDescription() != null)
            return false;
        if (!Arrays.equals(getPosition(), office.getPosition())) return false;
        if (getContacts() != null ? !getContacts().equals(office.getContacts()) : office.getContacts() != null)
            return false;
        if (getSchedules() != null ? !getSchedules().equals(office.getSchedules()) : office.getSchedules() != null)
            return false;
        return getOrganization() != null ? getOrganization().equals(office.getOrganization()) : office.getOrganization() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getPosition());
        result = 31 * result + (getContacts() != null ? getContacts().hashCode() : 0);
        result = 31 * result + (getSchedules() != null ? getSchedules().hashCode() : 0);
        result = 31 * result + (getOrganization() != null ? getOrganization().hashCode() : 0);
        return result;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
