package com.staxrt.tutorial.daoImpl;

import com.staxrt.tutorial.daos.CustomDao;
import com.staxrt.tutorial.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeCrudDaoImpl implements CustomDao<Employee, String> {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeCrudDaoImpl.class);


    EntityManager entityManager;

    @Autowired
    public void getEntityManager(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Optional<Employee> update(Employee e, String id) {
        Employee employee = null;
        try {
            entityManager.getTransaction().begin();
            Employee emp = entityManager.find(Employee.class, id);
            emp.setName(e.getName());
            emp.setTitle(e.getTitle());
            emp.setSalary(e.getSalary());
            emp.setAddress(e.getAddress());
            employee = entityManager.merge(emp);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            LOG.error("exception in update==> rollback");
            entityManager.getTransaction().rollback();
        }
        return Optional.of(employee);
    }

    @Override
    public void save(Employee emp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(emp);
            emp.setName("beforerFlush");
            entityManager.flush();
            emp.setName("beforerefresh");
            entityManager.refresh(emp);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            LOG.error("exception in update==> rollback");
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(String s) {
        try {
            entityManager.getTransaction().begin();
            Employee emp = entityManager.find(Employee.class, s);
            entityManager.remove(emp);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            LOG.error("exception in update==> rollback");
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void getAll() {
        List<Employee> resultList=entityManager.createQuery("select e from Employee e",Employee.class)
                .getResultList();
        resultList.forEach(employee -> System.out.println(employee.toString()));
    }

    @Override
    public void findById(String s) {
        try {
            entityManager.getTransaction().begin();
            Employee emp = entityManager.find(Employee.class, s);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            LOG.error("exception in update==> rollback");
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void addDD() {

    }

}
