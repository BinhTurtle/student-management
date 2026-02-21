package vn.edu.hcmut.cse.adsoftweng.lab.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import vn.edu.hcmut.cse.adsoftweng.lab.controller.StudentController;
import vn.edu.hcmut.cse.adsoftweng.lab.controller.StudentWebController;

@ControllerAdvice(assignableTypes = {StudentController.class, StudentWebController.class})
public class StudentExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("code", "400");
        response.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
