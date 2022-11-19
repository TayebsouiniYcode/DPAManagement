package com.dpamanagement.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
/*
    Définit qu’une classe est une entité. Le nom de l’entité est donné
    par l’attribut name (en son absence le nom de l’entité correspond au nom de la classe).
 */
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name= "phone")
    private String phone;

    @Column(name="username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="state")
    private boolean state;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "idRole")
    private Role role;

    //construct
    public Users ( Long id ) {this.id = id;}
    public Users() {}
    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }
    public Users ( Long id , String firstName , String lastName , String phone , String username , String email , String password , boolean state , Role role , List < Activity > activities ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
        this.state = state;
        this.role = role;
        this.activities = activities;
    }

    public Users( Long id, String firstName, String lastName, String phone, String username, String email, String password, boolean state, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.username = username;
        this.email = email;
        this.password = password;
        this.state = state;
        this.role = role;
    }


    public void setId(Long idUser) {
        this.id = idUser;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }



    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }




    @OneToMany(mappedBy = "responsable")
    private List<Activity> activities;

    public List < Activity > getActivities ( ) {
        return activities;
    }

    public void setActivities ( List < Activity > activities ) {
        this.activities = activities;
    }





    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + id +
                "firstName" + firstName +
                "lastName" + lastName +
                "phone" + phone +
                "username" + username +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
