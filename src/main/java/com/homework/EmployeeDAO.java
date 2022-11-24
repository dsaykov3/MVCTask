package com.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Repository
public class EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees() throws ClassNotFoundException {
        List<Employee> resultList = new ArrayList<>();
        resultList = jdbcTemplate.query("SELECT employee_id, first_name FROM employees\n", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setFirstName(resultSet.getString(2));
                return employee;
            }
        });

        return resultList;
    }

    public List<Employee> searchEmployee(int employeeID, String firstName, String lastName, String deptName) throws ClassNotFoundException {
        throw new RuntimeException("Not implemented");
    }

    public List<Employee> listAllEmployees() throws ClassNotFoundException {
        throw new RuntimeException("Not implemented");

    }

    public boolean deleteEmployee(int employee_id) throws ClassNotFoundException {
        throw new RuntimeException("Not implemented");
    }

    public boolean createEmployee(EmployeeData data) {
        throw new RuntimeException("Not implemented");
    }

    public Employee getEmployeeById(Integer id) {
        return jdbcTemplate.queryForObject("Select employee_id, first_name FROM employees WHERE employee_id= ? ",
                new RowMapper<Employee>() {
                    @Override
                    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                        Employee employee = new Employee();
                        employee.setEmployeeId(resultSet.getInt(1));
                        employee.setFirstName(resultSet.getString(2));
                        return employee;
                    }
                }, new Object[]{id});
    }
}
