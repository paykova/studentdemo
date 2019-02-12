package studentapp.service;

import org.modelmapper.ModelMapper;
import studentapp.domain.entities.Student;
import studentapp.domain.models.service.StudentServiceModel;
import studentapp.domain.models.view.StudentsListViewModel;
import studentapp.repository.StudentRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Inject
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveStudent(StudentServiceModel studentServiceModel) {
        try {
            this.studentRepository.save(this.modelMapper.map(studentServiceModel, Student.class));
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<StudentServiceModel> findAllStudents() {
       return this.studentRepository
                .findAllStudents()
                .stream()
                .map(e ->this.modelMapper.map(e,StudentServiceModel.class))
                .collect(Collectors.toList());
    }

}

