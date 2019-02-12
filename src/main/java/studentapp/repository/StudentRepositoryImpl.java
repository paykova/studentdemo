package studentapp.repository;

import studentapp.domain.entities.Student;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager entityManager;

    @Inject
    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student save(Student entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Student> findById(String id) {
        this.entityManager.getTransaction().begin();
        List<Student> students = this.entityManager.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class)
                .setParameter("id", id)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return students;
    }

    @Override
    public List<Student> findAllStudents() {
        this.entityManager.getTransaction().begin();
        List<Student> students = this.entityManager.createQuery("SELECT s FROM Student s ", Student.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return students;
    }
}
