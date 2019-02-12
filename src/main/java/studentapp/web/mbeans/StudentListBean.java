package studentapp.web.mbeans;

import org.modelmapper.ModelMapper;
import studentapp.domain.models.view.StudentsListViewModel;
import studentapp.service.StudentService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class StudentListBean {

    private List<StudentsListViewModel> studentsListViewModelList;
    private ModelMapper modelMapper;
    private StudentService studentService;

    public StudentListBean() {
    }

    @Inject
    public StudentListBean(ModelMapper modelMapper, StudentService studentService) {
        this.modelMapper = modelMapper;
        this.studentService = studentService;
        this.studentsListViewModelList = this.studentService.findAllStudents()
                .stream().map(e -> this.modelMapper.map(e, StudentsListViewModel.class))
        .collect(Collectors.toList());
    }


    public List<StudentsListViewModel> getStudentsListViewModelList() {
        return studentsListViewModelList;
    }

    public void setStudentsListViewModelList(List<StudentsListViewModel> studentsListViewModelList) {
        this.studentsListViewModelList = studentsListViewModelList;
    }
}
