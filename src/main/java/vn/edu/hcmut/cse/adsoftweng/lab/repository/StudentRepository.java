package vn.edu.hcmut.cse.adsoftweng.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.edu.hcmut.cse.adsoftweng.lab.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1% OR s.email LIKE %?1%")
    List<Student> findByNameOrEmailContaining(String keyword);
}
