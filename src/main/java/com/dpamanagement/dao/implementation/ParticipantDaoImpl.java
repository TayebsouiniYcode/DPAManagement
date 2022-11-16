package com.dpamanagement.dao.implementation;

import com.dpamanagement.dao.ParticipantDao;
import com.dpamanagement.entity.Participant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ParticipantDaoImpl implements ParticipantDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();

    @Override
    public Participant add(Participant p) {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
        return p;
    }

    @Override
    public List<Participant> getAll() {
        //CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //CriteriaQuery <Users> cq = cb.createQuery(Users.class);
        //Root <Users> rootEntry = cq.from(Users.class);
        //CriteriaQuery<Users> all = cq.select(rootEntry);
        //TypedQuery <Users> allQuery = entityManager.createQuery(all);
        //List<Users> usersList = allQuery.getResultList();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT p FROM Participant p");
        List<Participant> participantList = query.getResultList();
        entityManager.getTransaction().commit();

        System.out.println(participantList.toString());
        return participantList;
    }

    @Override
    public void update(Participant participant) {
        Participant _participant = entityManager.find(Participant.class, participant.getId());

        entityManager.getTransaction().begin();
        _participant.setFirstName(participant.getFirstName());
        _participant.setLastName(participant.getLastName());
        _participant.setEmail(participant.getEmail());
        _participant.setPhone(participant.getPhone());
        _participant.setState(participant.isState());
        _participant.setRole(participant.getRole());
        _participant.setStructure(participant.getStructure());
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Participant participant = entityManager.find(Participant.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(participant);
        entityManager.getTransaction().commit();
    }
}
