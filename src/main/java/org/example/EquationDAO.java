package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class EquationDAO {

    Configuration configuration = new Configuration().addAnnotatedClass(Equation.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    public void save(Equation equation) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(equation);
            session.getTransaction().commit();
        }
    }

    public List<Equation> findByRoot(double root) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Equation> equations = session.createQuery("FROM Equation where root = :root")
                    .setParameter("root", root).getResultList();
            session.getTransaction().commit();
            return equations;
        }
    }

    public List<Equation> findByNumberOfVariables(int numberOfVariables) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Equation> equations =
                    session.createQuery("FROM Equation where numberOfVariables = :n")
                            .setParameter("n", numberOfVariables).getResultList();
            session.getTransaction().commit();
            return equations;
        }
    }
}
