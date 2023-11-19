package com.votersystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votersystem.model.Register;
import com.votersystem.repository.RegisterRepo;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepo registerRepo;  // It means - RegisterRepo registerRepo = new RegisterRepoImpl();

    @Override
    public boolean addVoter(Register register) {
        if(register.getAge() > 18){
            return registerRepo.addVoter(register);
        }
        return false; 
    }

    @Override
    public List<Register> getVoterList() {
        return registerRepo.getVoterList();
    }

    @Override
    public boolean deleteVoter(int id) {
        return registerRepo.deleteVoter(id);
    }

    @Override
    public boolean updateVoter(Register register) {
        return registerRepo.updateVoter(register);
    }

    @Override
    public Register getVoterDetail(int id) {
        return registerRepo.getVoterDetail(id);
    }
    
}
