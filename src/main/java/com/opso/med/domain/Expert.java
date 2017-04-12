package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
@Document(collection = "expert")
public class Expert implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Indexed
    @Size(max = 15)
    @Field("code")
    private String code;

    @NotNull
    @Size(max = 250)
    @Indexed
    @Field("last_name")
    private String lastName;

    @NotNull
    @Indexed
    @Size(max = 250)
    @Field("first_name")
    private String firstName;

    @Field("contact")
    private Contact contact;

    @Field("jobs")
    private Set<Job> jobs;

    @Field("services")
    private Set<Service> services;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Expert code(String code) {
        this.code = code;
        return this;
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
    public Expert lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Expert firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expert)) return false;

        Expert expert = (Expert) o;

        if (id != null ? !id.equals(expert.id) : expert.id != null) return false;
        if (code != null ? !code.equals(expert.code) : expert.code != null) return false;
        if (lastName != null ? !lastName.equals(expert.lastName) : expert.lastName != null) return false;
        if (firstName != null ? !firstName.equals(expert.firstName) : expert.firstName != null) return false;
        if (contact != null ? !contact.equals(expert.contact) : expert.contact != null) return false;
        if (jobs != null ? !jobs.equals(expert.jobs) : expert.jobs != null) return false;
        return services != null ? services.equals(expert.services) : expert.services == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (jobs != null ? jobs.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Expert{" +
            "id='" + id + '\'' +
            ", code='" + code + '\'' +
            ", lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", contact=" + contact +
            ", jobs=" + jobs +
            ", services=" + services +
            '}';
    }
}
