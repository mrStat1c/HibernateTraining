package service;

import businessLogic.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {
    @Override
    public void add(Project project) {
        openTransactionSession();
        Session session = getSession();
        session.save(project);
        closeTransactionSession();
    }

    @Override
    public List<Project> getAll() {
        openTransactionSession();
        String hql = "FROM Project";
        Session session = getSession();
        Query query = session.createQuery(hql);
        List<Project> projectList = query.list();
        closeTransactionSession();
        return projectList;
    }

    @Override
    public Project getById(long id) {
        openTransactionSession();
        String sql = "FROM Project WHERE id = :id";
        Session session = getSession();
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        Project project = (Project) query.getSingleResult();
        closeTransactionSession();
        return project;
    }

    @Override
    public void update(Project project) {
        openTransactionSession();
        Session session = getSession();
        session.update(project);
        closeTransactionSession();
    }

    @Override
    public void remove(Project project) {
        openTransactionSession();
        Session session = getSession();
        session.remove(project);
        closeTransactionSession();
    }
}
