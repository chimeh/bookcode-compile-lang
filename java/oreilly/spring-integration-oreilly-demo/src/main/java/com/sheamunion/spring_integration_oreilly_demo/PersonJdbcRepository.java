package com.sheamunion.spring_integration_oreilly_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    SpringIntegrationOreillyDemoApplication.PersonRowMapper personRowMapper;

    public Person findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from person where id = ?"
                , new Object[] { id }
                , new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", personRowMapper);
    }
}
