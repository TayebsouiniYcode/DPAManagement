package com.dpamanagement.service.implementation;

import com.dpamanagement.entity.Participant;
import com.dpamanagement.repository.ParticipantRepository;
import com.dpamanagement.repository.implementation.ParticipantRepositoryImpl;
import com.dpamanagement.service.ParticipantService;
import com.dpamanagement.entity.Participant;
import com.dpamanagement.repository.ParticipantRepository;
import com.dpamanagement.repository.implementation.ParticipantRepositoryImpl;

import java.util.List;

public class ParticipantServiceImpl implements ParticipantService {
    ParticipantRepository participantRepo = new ParticipantRepositoryImpl ();

    @Override
    public Participant add( Participant participant) {
        return participantRepo.add(participant);
    }

    @Override
    public Participant login ( Participant participant ) {
        return participantRepo.login(participant);
    }

    @Override
    public List < Participant > getAll ( ) {
        return participantRepo.getAll();
    }

    @Override
    public void update ( Participant participant ) {
        participantRepo.update(participant);
    }

    @Override
    public void delete ( int id ) {
        participantRepo.delete(id);
    }
}
