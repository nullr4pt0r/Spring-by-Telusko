package com.dnl.jdbc.repository;

import com.dnl.jdbc.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@repository to mark repository layer
@Repository
public class AlienRepo {

    //juse jdbc template to interact with db
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired //to let the spring create object of the jdbc templte
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  void save(Alien alien){
        //add the data to db
        String sql = "insert into alien (id,name,tech) values(?,?,?)";
       int rows =  jdbcTemplate.update(sql,alien.getId(),alien.getName(),alien.getTech());
        System.out.println("rows affected : "+rows);
    }

    public List<Alien> getAllAlien(){

        String sql = "Select * from alien";

        //rowmapper use to fetch the single row at a time based on rownum from the resultset. mapper runs for
        //the number of records resultset contains
        //Row mapper is to get list of data and process it
        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien = new Alien();
                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));
                return alien;
            }
        };
        //it queries the database and extracts the data using mapper and returns the list of data
        List<Alien> alienList = jdbcTemplate.query(sql,mapper);
        return alienList;
    }


    public Alien getAlienById(int id){
        //String sql = "select * from alien where id ="+id; => this may lead to SQLI
        String sql = "select * from alien where id =?";

        //resultsetextractor is to extract only onr result

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien = new Alien();
                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));
                return alien;
            }
        };

        try {
            Alien alien = jdbcTemplate.queryForObject(sql, new Object[]{id}, mapper);
            return alien;
        }
        //there may be empty result for the given id
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }




}
