package dao;

import entity.Employee;
import entity.Item;

import java.util.List;

public interface EmployeeDAO {

    void add(Employee employee);
    List<Employee> getAll();
    Employee getById(long id);
    Employee getByFio(String firstName, String secondName);
    void update(Employee employee);
    void remove(Employee employee);
}
