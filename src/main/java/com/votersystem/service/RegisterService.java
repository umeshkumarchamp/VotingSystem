package com.votersystem.service;

import java.util.List;

import com.votersystem.model.Register;

public interface RegisterService {

    public boolean addVoter(Register register);

    public List<Register> getVoterList();

    public boolean deleteVoter(int id);

    public boolean updateVoter(Register register);

    public Register getVoterDetail(int id);

}
