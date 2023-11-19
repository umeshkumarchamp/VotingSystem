package com.votersystem.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.votersystem.model.Register;

public class RowMapperImpl implements RowMapper<Register> {

    @Override
    public Register mapRow(ResultSet rs, int rowNum) throws SQLException {

        Register register = new Register();
        register.setId(rs.getInt("id"));    
        register.setName(rs.getString("name"));
        register.setEmail(rs.getString("email"));
        register.setAge(rs.getInt("age"));
        register.setContact(rs.getLong("contact"));

        return register;
        
    }
    
}
