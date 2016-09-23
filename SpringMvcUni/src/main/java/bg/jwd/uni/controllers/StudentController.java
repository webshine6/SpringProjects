package bg.jwd.uni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.constants.UrlConstants;
import bg.jwd.uni.enities.Student;
import bg.jwd.uni.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;

	@RequestMapping(value = UrlConstants.STUDENT_REGISTY_URL, method = RequestMethod.GET)
	public String getStudents(Model model) {
		model.addAttribute("students", studentService.getStudents());
		model.addAttribute("addStudentUrl", UrlConstants.ADD_STUDENT_URL);
		return "studentRegister";
	}

	@RequestMapping(value = UrlConstants.ADD_STUDENT_URL, method = RequestMethod.GET)
	public String addStudent() {
		return "addStudent";
	}

	@RequestMapping(value = UrlConstants.ADD_STUDENT_SAVE_URL, method = RequestMethod.POST)
	public String addStudentSave(Model model, @ModelAttribute(value = "StringWeb") Student student) {
		studentService.addStudent(student);

		model.addAttribute("students", studentService.getStudents());

		return "studentRegister";
	}

}
