package com.dpamanagement.service;

import com.dpamanagement.entity.Participant;

import java.util.List;

public interface ParticipantService {
    Participant add(Participant p);
    Participant login(Participant participant);
    List<Participant> getAll();
    void update(Participant user);
    void delete(int id);
}
