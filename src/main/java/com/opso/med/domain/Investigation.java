package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
@Document(collection = "investigation")
public class Investigation {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("start_ts")
    private LocalDateTime startTs;

    @NotNull
    @Field("end_ts")
    private LocalDateTime endTs;

    @NotNull
    @Field("status")
    private Long status;

    @NotNull
    @Field("type")
    private String type; //OPERATION/PRESCRIPTION/ANALYSIS/RADIOGRAM

    @Field("organization")
    private Organization organization;

    @Field("office")
    private Office office;

    @Field("services")
    private Set<JobService> services;

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

    @DBRef // ??? Poate ca ar fi mai bine sa embeduim programarea cu totul
    @Field("appointment")
    private Appointment appointment;

    @Field("documents")
    private Set<DocumentFile> documents;

    @Field("notes")
    private Set<String> notes;


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

    public LocalDateTime getEndTs() {
        return endTs;
    }

    public void setEndTs(LocalDateTime endTs) {
        this.endTs = endTs;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Set<JobService> getServices() {
        return services;
    }

    public void setServices(Set<JobService> services) {
        this.services = services;
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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Set<DocumentFile> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<DocumentFile> documents) {
        this.documents = documents;
    }

    public Set<String> getNotes() {
        return notes;
    }

    public void setNotes(Set<String> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Investigation)) return false;

        Investigation that = (Investigation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startTs != null ? !startTs.equals(that.startTs) : that.startTs != null) return false;
        if (endTs != null ? !endTs.equals(that.endTs) : that.endTs != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (office != null ? !office.equals(that.office) : that.office != null) return false;
        if (services != null ? !services.equals(that.services) : that.services != null) return false;
        if (expert != null ? !expert.equals(that.expert) : that.expert != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (appointment != null ? !appointment.equals(that.appointment) : that.appointment != null) return false;
        if (documents != null ? !documents.equals(that.documents) : that.documents != null) return false;
        return notes != null ? notes.equals(that.notes) : that.notes == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startTs != null ? startTs.hashCode() : 0);
        result = 31 * result + (endTs != null ? endTs.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        result = 31 * result + (expert != null ? expert.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (appointment != null ? appointment.hashCode() : 0);
        result = 31 * result + (documents != null ? documents.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Investigation{" +
            "id='" + id + '\'' +
            ", startTs=" + startTs +
            ", endTs=" + endTs +
            ", status=" + status +
            ", type='" + type + '\'' +
            ", organization=" + organization +
            ", office=" + office +
            ", services=" + services +
            ", expert=" + expert +
            ", customer=" + customer +
            ", appointment=" + appointment +
            ", documents=" + documents +
            ", notes=" + notes +
            '}';
    }
}
