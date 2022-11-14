package ru.job4j.todo.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.todo.model.Task;
import java.util.List;

@Repository
public class TaskRepository {

    private final SessionFactory sf;

    public TaskRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Task> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Task> result = session.createQuery("from ru.job4j.todo.model.Task", Task.class).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

}