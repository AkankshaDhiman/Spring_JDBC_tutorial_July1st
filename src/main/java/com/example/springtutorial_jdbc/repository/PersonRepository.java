package com.example.springtutorial_jdbc.repository;

import com.example.springtutorial_jdbc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Person person) {
        String sql="insert into person(name,age) values(?,?)";
        int row = jdbcTemplate.update(sql,person.getName(),person.getAge());
        System.out.println("added new row: "+row);

    }
}
