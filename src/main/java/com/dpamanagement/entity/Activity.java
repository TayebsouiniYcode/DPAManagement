package com.dpamanagement.entity;

import jakarta.persistence.*;
import jakarta.servlet.http.Part;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public Exercice getExercise() {
        return exercise;
    }

    public void setExercise(Exercice exercise) {
        this.exercise = exercise;
    }

    @Column(name= "title", nullable = false)
    private String title;

    @Column(name= "description" , nullable = true)
    private String description;

    @Column(name= "dateDebut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "dateFin", nullable = true)
    private LocalDate dateFin;

    @Column(name = "status")
    private Boolean status;

    // Relationship
    @OneToMany
    private List<Participant> participantList = new ArrayList <> ();

    @ManyToOne
    private Users responsable;

    public Users getResponsable ( ) {
        return responsable;
    }

    public void setResponsable ( Users responsable ) {
        this.responsable = responsable;
    }

    public Activity ( Long id , String title , String description , LocalDate dateDebut , LocalDate dateFin , Boolean status , List < Participant > participantList , Users responsable , Exercice exercise ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.status = status;
        this.participantList = participantList;
        this.responsable = responsable;
        this.exercise = exercise;
    }

    public Activity() {}

    @OneToOne
    //@JoinColumn(name = "exercice_id", referencedColumnName = "id")
    private Exercice exercise;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString ( ) {
        return "Activity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", status=" + status +
                ", participantList=" + participantList +
                ", responsable=" + responsable +
                ", exercise=" + exercise +
                '}';
    }
}
