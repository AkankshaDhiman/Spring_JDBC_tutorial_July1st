package com.example.springtutorial_jdbc.repository;

import com.example.springtutorial_jdbc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "insert into person(name,age) values(?,?)";
        int row = jdbcTemplate.update(sql, person.getName(), person.getAge());
        System.out.println("added new row: " + row);

    }

    public List<Person> findAll() {
//        List<Person> persons=new ArrayList<Person>();
//
//        return persons;
        String sql = "select * from person";
        RowMapper<Person> rowMapper = new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));
                return person;
            }
        };
        List<Person> personList = jdbcTemplate.query(sql, rowMapper);
        return personList;
    }
}

