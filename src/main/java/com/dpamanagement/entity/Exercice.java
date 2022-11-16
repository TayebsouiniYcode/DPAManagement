package com.dpamanagement.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Exercice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    //@Temporal(TemporalType.DATE)
    private String year;

    //@Temporal(TemporalType.DATE)
    private LocalDate dateStart;

    //@Temporal(TemporalType.DATE)
    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name="state")
    private boolean state;

    @Column(name="description")
    private String description;

    public Exercice ( String year , LocalDate dateDebut , LocalDate dateFin , Boolean status , String description ) {
        this.year = year; this.dateStart = dateDebut; this.endDate = dateFin;
        this.state = status; this.description = description;
    }

    public Exercice ( ) {}

    public String getDescription ( ) {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public Exercice (String year , LocalDate dateStart , LocalDate endDate , boolean state , String description ) {
        this.year = year;
        this.dateStart = dateStart;
        this.endDate = endDate;
        this.state = state;
        this.description = description;
    }

    public Exercice ( Long id , String year , LocalDate dateStart , LocalDate endDate , boolean state , String description ) {
        this.id = id;
        this.year = year;
        this.dateStart = dateStart;
        this.endDate = endDate;
        this.state = state;
        this.description = description;
    }

    public Long getId ( ) {
        return id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Exercice ( String year , LocalDate dateStart , LocalDate endDate , boolean state ) {
        this.year = year;
        this.dateStart = dateStart;
        this.endDate = endDate;
        this.state = state;
    }

    public Exercice ( Long id ) {
        this.id = id;
    }

    @Override
    public String toString ( ) {
        return "Exercise{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", dateStart=" + dateStart +
                ", endDate=" + endDate +
                ", state=" + state +
                '}';
    }
}
