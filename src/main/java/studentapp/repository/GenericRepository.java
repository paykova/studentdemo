package studentapp.repository;

import java.util.List;

public interface GenericRepository<E, ID> {

    E save(E entity);

    List<E> findById(ID id);

    List<E> findAllStudents();


}
