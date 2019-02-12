package studentapp.web.mbeans;

import org.modelmapper.ModelMapper;
import studentapp.domain.models.binding.StudentRegisterBindingModel;
import studentapp.domain.models.service.StudentServiceModel;
import studentapp.service.StudentService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class StudentRegisterBean {

    private StudentRegisterBindingModel studentRegisterBindingModel;
    private StudentService studentService;
    private ModelMapper modelMapper;

    public StudentRegisterBean() {

        this.studentRegisterBindingModel = new StudentRegisterBindingModel();
    }

    @Inject
    public StudentRegisterBean(StudentService studentService, ModelMapper modelMapper) {
        this();
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    public StudentRegisterBindingModel getStudentRegisterBindingModel() {
        return studentRegisterBindingModel;
    }

    public void setStudentRegisterBindingModel(StudentRegisterBindingModel studentRegisterBindingModel) {
        this.studentRegisterBindingModel = studentRegisterBindingModel;
    }

    public void register() throws IOException {
        this.studentService.saveStudent(this.modelMapper.map(this.studentRegisterBindingModel, StudentServiceModel.class));
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }
}
