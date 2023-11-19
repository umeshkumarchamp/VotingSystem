package com.votersystem.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.votersystem.model.Register;

@Repository("registerRepo")
public class RegisterRepoImpl implements RegisterRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate; 

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean addVoter(Register register) {
        String query = "INSERT INTO register (name, email, contact, age) VALUES ( ?, ?, ?, ?)";
        int res = this.jdbcTemplate.update(query, register.getName(), register.getEmail(), register.getContact(), register.getAge());
        if(res>0){
            return true; 
        }else{
            return false;
        }
    }


    @Override
    public List<Register> getVoterList() {
        String query = "SELECT * FROM register";
        List<Register> list = this.jdbcTemplate.query(query, new RowMapperImpl());
        return list;
    }


    @Override
    public boolean deleteVoter(int id) {
        String query = "DELETE FROM register WHERE id = ?";
        int res = this.jdbcTemplate.update(query, id);
        if(res>0){
            return true;
        }
        return false; 
    }


    @Override
    public boolean updateVoter(Register register) {
        String query = "UPDATE register SET name=?, email=?, contact=?,age=? WHERE id=?";
        int res = this.jdbcTemplate.update(query, register.getName(), register.getEmail(), register.getContact(), register.getAge(), register.getId());
        if(res>0){
            return true; 
        }else{
            return false;
        }
    }


    @Override
    public Register getVoterDetail(int id) {
        String query = "SELECT * FROM register WHERE id=?";
        Register result = this.jdbcTemplate.queryForObject(query, new RowMapperImpl(),id);
        return result;
    }
    
}
