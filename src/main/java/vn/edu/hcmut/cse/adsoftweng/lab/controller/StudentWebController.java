package vn.edu.hcmut.cse.adsoftweng.lab.controller;

import java.util.List;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            students= studentService.getAll();
        } else {
            students = studentService.getByKeyword(keyword);
        }
        // 2. Đóng gói dữ liệu vào "Model" đe chuyen sang View
        // Key "dsSinhVien" sẽ được dùng bên file HTML
        model.addAttribute("dsSinhVien", students);
        logger.info("Info retrieved");
        // 3. Trả vê ̀tên của View (không cân đuôi .html)
        // Spring Boot sẽ tự tìm file tại: src/main/resources/templates/students.html
        return "students";
    }
}
