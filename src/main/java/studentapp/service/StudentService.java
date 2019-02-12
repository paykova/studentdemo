package studentapp.service;

import studentapp.domain.models.service.StudentServiceModel;

import java.util.List;

public interface StudentService {

    boolean saveStudent(StudentServiceModel studentServiceModel);

    List<StudentServiceModel> findAllStudents();
}
