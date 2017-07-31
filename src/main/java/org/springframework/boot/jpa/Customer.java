package org.springframework.boot.jpa;

import javax.persistence.*;

@Entity
public class Customer {

    //http://www.oracle.com/technetwork/middleware/ias/id-generation-083058.html
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String email;

    @Column(name = "CUSTOM")
    @Convert(converter=MyCustomDataConverter.class)
    MyCustomData customData;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", customData='"+customData.getValue()+'\''+
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MyCustomData getCustomData() {
        return customData;
    }

    public void setCustomData(MyCustomData customData) {
        this.customData = customData;
    }
}
