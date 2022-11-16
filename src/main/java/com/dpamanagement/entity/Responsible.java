package com.dpamanagement.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Responsible")
public class Responsible  extends Users{

    @Column(name="domain")
    private String domain;

    //@Column(name="type")
    //@Enumerated(EnumType.STRING)
    //private TypeResponsible type;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }




}
