package com.opso.med.domain;


import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
@Document(collection = "contact")
public class Contact {

    @Id
    private String id;
    private static final long serialVersionUID = 1L;

    @Field("phone")
    private String phone;

    @Field("fax")
    private String fax;

    @Email
    @Indexed
    @Field("email")
    private String email;

    @Indexed
    @Field("name")
    private String name;

    @Indexed
    @Field("address")
    private String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (fax != null ? !fax.equals(contact.fax) : contact.fax != null) return false;
        if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        return address != null ? address.equals(contact.address) : contact.address == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
            "id='" + id + '\'' +
            ", phone='" + phone + '\'' +
            ", fax='" + fax + '\'' +
            ", email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
