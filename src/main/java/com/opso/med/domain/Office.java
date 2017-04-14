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

    @Field("organization")
    private Organization organization;


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

    public Office name(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Office description(String description) {
        this.description = description;
        return this;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public Office position(double[]  position) {
        this.position = position;
        return this;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Office contacts(Set<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Office organization(Organization organization) {
        this.organization = organization;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Office)) return false;

        Office office = (Office) o;

        if (id != null ? !id.equals(office.id) : office.id != null) return false;
        if (name != null ? !name.equals(office.name) : office.name != null) return false;
        if (description != null ? !description.equals(office.description) : office.description != null) return false;
        if (!Arrays.equals(position, office.position)) return false;
        if (contacts != null ? !contacts.equals(office.contacts) : office.contacts != null) return false;
        return organization != null ? organization.equals(office.organization) : office.organization == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(position);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Office{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", position=" + Arrays.toString(position) +
            ", contacts=" + contacts +
            ", organization=" + organization +
            '}';
    }
}
