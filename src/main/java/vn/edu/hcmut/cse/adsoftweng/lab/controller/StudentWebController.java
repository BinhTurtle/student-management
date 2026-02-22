package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import java.util.List;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.hcmut.cse.adsoftweng.lab.dto.StudentDto;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StudentWebController.class);

    @Autowired
    private StudentService studentService;

    // Route: GET http://localhost:8080/students
    @GetMapping
    public String getAllStudents(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        // 1. Lâ ́y dữ liệu từ Service
        List<Student> students;

        if (keyword == null || keyword.isEmpty()) {
            students = studentService.getAll();
        } else {
            students = studentService.getByKeyword(keyword);
        }

        // 2. Đóng gói dữ liệu vào "Model" đe chuyen sang View
        // Key "dsSinhVien" sẽ được dùng bên file HTML
        model.addAttribute("dsSinhVien", students);
        logger.info("Info retrieved");

        // Truyen san dto rong de phuc vu cho modal them sinh vien moi
        model.addAttribute("studentDto", new StudentDto());

        // 3. Trả vê ̀tên của View (không cân đuôi .html)
        // Spring Boot sẽ tự tìm file tại: src/main/resources/templates/students.html
        return "students";
    }

    // Route: GET /students/{id}
    @GetMapping("/{id}")
    public String getStudentDetail(@PathVariable String id, Model model) {
        Student student = studentService.getById(id);

        model.addAttribute("student", student);

        // Chuẩn bị sẵn dto để phục vụ cho Modal "Chỉnh Sửa" nằm trong trang chi tiết
        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setAge(student.getAge());
        model.addAttribute("studentDto", studentDto);

        logger.info("Info retrieved for ID: " + id);

        return "student-detail";
    }

    // Route: POST /students/create
    @PostMapping("/create")
    public String createStudent(@ModelAttribute StudentDto studentDto) {
        studentService.createNewStudent(studentDto);
        logger.info("Info created");

        // Sau khi tạo xong, redirect về trang danh sách
        return "redirect:/students";
    }

    // Route: PUT /students/edit/{id}
    @PutMapping("/edit/{id}")
    public String updateStudent(@PathVariable String id, @ModelAttribute StudentDto studentDto) {
        studentService.updateStudent(studentDto, id);
        logger.info("Info updated for ID: " + id);

        // Sau khi lưu xong, redirect về trang chi tiết của sinh viên đó
        return "redirect:/students/" + id;
    }

    // Route: DELETE /students/delete/{id}
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        logger.info("Student deleted for ID: " + id);

        // Sau khi xóa xong, redirect về trang danh sách
        return "redirect:/students";
    }

}
