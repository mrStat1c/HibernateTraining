package service;

import businessLogic.SessionUtil;
import dao.EmployeeDAO;
import entity.Employee;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService extends SessionUtil implements EmployeeDAO {
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
        String hql = "FROM Employee";
        Session session = getSession();
        Query query = session.createQuery(hql);
        List<Employee> employeeList = query.list();
        closeTransactionSession();
        return employeeList;
    }

    @Override
    public Employee getById(long id) {
        openTransactionSession();
        String hql = "FROM Employee WHERE id = :id";
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Employee employee = (Employee) query.getSingleResult();
        closeTransactionSession();
        return employee;
    }

    @Override
    public Employee getByFio(String firstName, String secondName) {
        openTransactionSession();
        String hql = "FROM Employee WHERE firstName = :firstName AND secondName = :secondName";
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setParameter("firstName", firstName);
        query.setParameter("secondName", secondName);
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
