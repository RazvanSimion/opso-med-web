package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    @Field("start_ts")
    private LocalDateTime startTs;

    @NotNull
    @Indexed
    @Field("end_ts")
    private LocalDateTime endTs;


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

    public LocalDateTime getEndTs() {
        return endTs;
    }

    public void setEndTs(LocalDateTime endTs) {
        this.endTs = endTs;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Availability)) return false;

        Availability that = (Availability) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startTs != null ? !startTs.equals(that.startTs) : that.startTs != null) return false;
        if (endTs != null ? !endTs.equals(that.endTs) : that.endTs != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (office != null ? !office.equals(that.office) : that.office != null) return false;
        return expert != null ? expert.equals(that.expert) : that.expert == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startTs != null ? startTs.hashCode() : 0);
        result = 31 * result + (endTs != null ? endTs.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        result = 31 * result + (expert != null ? expert.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Availability{" +
            "id='" + id + '\'' +
            ", startTs=" + startTs +
            ", endTs=" + endTs +
            ", organization=" + organization +
            ", office=" + office +
            ", expert=" + expert +
            '}';
    }
}
