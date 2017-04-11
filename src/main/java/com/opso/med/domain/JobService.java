package com.opso.med.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
public class JobService {
    private static final long serialVersionUID = 1L;

    private Service service;

    private double value;

    public JobService() {
    }

    public JobService(Service service, double value) {
        this.service = service;
        this.value = value;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobService)) return false;

        JobService that = (JobService) o;

        if (Double.compare(that.getValue(), getValue()) != 0) return false;
        return getService() != null ? getService().equals(that.getService()) : that.getService() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getService() != null ? getService().hashCode() : 0;
        temp = Double.doubleToLongBits(getValue());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "JobService{" +
            "id='" +
            ", service=" + service +
            ", value=" + value +
            '}';
    }
}
