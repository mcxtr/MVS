package it.repositorylmpl;

import it.model.Student;
import it.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class UserRepositorylmp implements StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);


    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Student.class,id));

    }

    @Override
    public Student findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select s from Student s,Student.class").getResultList();
    }

    @Override
    public void update(Student student, Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = session.get(Student.class,id);
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        session.merge(student1);
    }
}
