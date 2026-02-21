package vn.edu.hcmut.cse.adsoftweng.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.hcmut.cse.adsoftweng.lab.dto.StudentDto;
import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;
import vn.edu.hcmut.cse.adsoftweng.lab.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student ID không tồn tại"));
    }

    public List<Student> getByKeyword(String keyword) {


        return studentRepository.findByNameOrEmailContaining(keyword);
    }

    public Student createNewStudent(StudentDto studentDto) {
        int randomId = (int) (Math.random() * 10000);

        while (studentRepository.findById(String.valueOf(randomId)).isPresent()) {
            randomId = (int) (Math.random() * 10000);
        }

        Student student = Student.builder()
                .id(String.valueOf(randomId))
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .age(studentDto.getAge())
                .build();

        studentRepository.save(student);

        return student;
    }

    public void updateStudent(StudentDto studentDto, String id) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new IllegalArgumentException("Student ID không tồn tại");
        }

        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());

        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new IllegalArgumentException("Student ID không tồn tại");
        }

        studentRepository.delete(student);
    }

}
