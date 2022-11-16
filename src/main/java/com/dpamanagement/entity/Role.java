package com.dpamanagement.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRole" ,nullable=false)
    private Long idRole;
    @Column(name="name",nullable = false)
    private String name;

    @Transient
    @OneToMany(mappedBy = "role")
    List<Users> userList;

    public Role(Long idRole, String name, List<Users> userList) {
        this.idRole = idRole;
        this.name = name;
        this.userList = userList;
    }
    public Role(Long idRole){
        this.idRole=idRole;

    }
    public Role() {
    }

    public Role ( Long idRole , String name ) {
        this.idRole = idRole;
        this.name = name;
    }

    public void setIdRole( Long idRole) {
        this.idRole = idRole;
    }


    public Long getIdRole() {
        return idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", name='" + name + '\'' +
                '}';
    }
}
