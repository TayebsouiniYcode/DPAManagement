package com.dpamanagement.entity;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="participant")
public class Participant extends Users{
    public Participant(Long id, String firstName, String lastName, String phone, String username, String email, String password, boolean state, Role role, String structure, String domaine) {
        super(id, firstName, lastName, phone, username, email, password, state, role);
        this.domain = domaine;
        this.structure = structure;
    }


    @Column(name="domain")
    private String domain;

    @Column(name="structure")
    private String structure;

    public Participant() {

    }

    public Participant ( long parseLong ) {
        setId ( parseLong );
    }

    public Participant ( Long id , String firstname , String lastname , String phone , Object o , String email , Object o1 , Boolean status , Role role , String structure ) {

    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }
}
