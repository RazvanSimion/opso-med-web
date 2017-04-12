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
public class OfficeRef {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String description;

    private double[] position;

    private Organization organization;


    public OfficeRef() {
    }

    public OfficeRef(String id, String name, String description, double[] position, Organization organization) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.position = position;
        this.organization = organization;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfficeRef)) return false;

        OfficeRef officeRef = (OfficeRef) o;

        if (id != null ? !id.equals(officeRef.id) : officeRef.id != null) return false;
        if (name != null ? !name.equals(officeRef.name) : officeRef.name != null) return false;
        if (description != null ? !description.equals(officeRef.description) : officeRef.description != null)
            return false;
        if (!Arrays.equals(position, officeRef.position)) return false;
        return organization != null ? organization.equals(officeRef.organization) : officeRef.organization == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(position);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OfficeRef{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", position=" + Arrays.toString(position) +
            ", organization=" + organization +
            '}';
    }
}
