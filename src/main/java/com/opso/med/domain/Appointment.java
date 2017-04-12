package com.opso.med.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
@Document(collection = "appointment")
public class Appointment {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Indexed
    @Field("start_ts")
    private ZonedDateTime startTs;

    @NotNull
    @Indexed
    @Field("end_ts")
    private ZonedDateTime endTs;

    @NotNull
    @Indexed
    @Field("status")
    private Long status; //0 - Programat, -1 - Anulat, 1 - Efectuata

    @Field("organization")
    private Organization organization;

    @Field("office")
    private OfficeRef office;

    /*@DBRef // ??? Poate ca ar fi mai bine sa embeduim expertul cu totul
    @Field("expert")
    private Expert expert;*/

    /*@DBRef // ??? Poate ca ar fi mai bine sa embeduim clientul cu totul
    @Field("customer")
    private Customer customer;*/

    @Field("expert")
    private ExpertRef expert;

    @Field("customer")
    private CustomerRef customer;

    @Field("services")
    private Set<Service> services;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime getStartTs() {
        return startTs;
    }

    public void setStartTs(ZonedDateTime startTs) {
        this.startTs = startTs;
    }

    public ZonedDateTime getEndTs() {
        return endTs;
    }

    public void setEndTs(ZonedDateTime endTs) {
        this.endTs = endTs;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public OfficeRef getOffice() {
        return office;
    }

    public void setOffice(OfficeRef office) {
        this.office = office;
    }

    public ExpertRef getExpert() {
        return expert;
    }

    public void setExpert(ExpertRef expert) {
        this.expert = expert;
    }

    public CustomerRef getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerRef customer) {
        this.customer = customer;
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
        if (!(o instanceof Appointment)) return false;

        Appointment that = (Appointment) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startTs != null ? !startTs.equals(that.startTs) : that.startTs != null) return false;
        if (endTs != null ? !endTs.equals(that.endTs) : that.endTs != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (office != null ? !office.equals(that.office) : that.office != null) return false;
        if (expert != null ? !expert.equals(that.expert) : that.expert != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        return services != null ? services.equals(that.services) : that.services == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startTs != null ? startTs.hashCode() : 0);
        result = 31 * result + (endTs != null ? endTs.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (expert != null ? expert.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id='" + id + '\'' +
            ", startTs=" + startTs +
            ", endTs=" + endTs +
            ", status=" + status +
            ", organization=" + organization +
            ", office=" + office +
            ", expert=" + expert +
            ", customer=" + customer +
            ", services=" + services +
            '}';
    }
}
