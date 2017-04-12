package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
public class ExpertRef {
    private static final long serialVersionUID = 1L;

    private String id;

    private String code;
    private String lastName;

    private String firstName;

    public ExpertRef() {
    }

    public ExpertRef(Expert expert) {
        this.id = expert.getId();
        this.code = expert.getCode();
        this.lastName = expert.getLastName();
        this.firstName = expert.getFirstName();
    }

    @Override
    public String toString() {
        return "ExpertRef{" +
            "id='" + id + '\'' +
            ", code='" + code + '\'' +
            ", lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpertRef)) return false;

        ExpertRef expertRef = (ExpertRef) o;

        if (getId() != null ? !getId().equals(expertRef.getId()) : expertRef.getId() != null) return false;
        if (getCode() != null ? !getCode().equals(expertRef.getCode()) : expertRef.getCode() != null) return false;
        if (getLastName() != null ? !getLastName().equals(expertRef.getLastName()) : expertRef.getLastName() != null)
            return false;
        return getFirstName() != null ? getFirstName().equals(expertRef.getFirstName()) : expertRef.getFirstName() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
