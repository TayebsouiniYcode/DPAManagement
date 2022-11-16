package com.dpamanagement.dao;

import com.dpamanagement.entity.Participant;
import com.dpamanagement.entity.Participant;

import java.util.List;

public interface ParticipantDao {
    Participant add( Participant p);

    List<Participant> getAll();

    void update(Participant participant);

    void delete(int id);
}
