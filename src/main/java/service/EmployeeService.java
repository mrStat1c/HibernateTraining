package service;

import businessLogic.SesseionUtil;
import dao.EmployeeDAO;
import entity.Address;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService extends SesseionUtil implements EmployeeDAO {
    @Override
    public void add(Employee employee) {
        openTransactionSession();
        Session session = getSession();
        session.save(employee);
        closeTransactionSession();
    }

    @Override
    public List<Employee> getAll() {
        openTransactionSession();
        String sql = "SELECT * FROM employee";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Employee> employeeList = query.list();
        closeTransactionSession();
        return employeeList;
    }

    @Override
    public Employee getById(long id) {
        openTransactionSession();
        String sql = "SELECT * FROM employee WHERE id = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);
        Employee employee = (Employee) query.getSingleResult();
        closeTransactionSession();
        return employee;
    }

    @Override
    public void update(Employee employee) {
        openTransactionSession();
        Session session = getSession();
        session.update(employee);
        closeTransactionSession();
    }

    @Override
    public void remove(Employee employee) {
        openTransactionSession();
        Session session = getSession();
        session.remove(employee);
        closeTransactionSession();
    }
}
