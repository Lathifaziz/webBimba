package app.Bimba.service;

import app.Bimba.model.Student;

import java.io.IOException;
import java.util.List;

import app.Bimba.model.WaliMurid;
import app.Bimba.util.DTO.RegisterStudent;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService {
    void create(RegisterStudent request, MultipartFile file) throws IOException;

    Page<Student> getAll(String request, int size, int page);

    Page<Student> getAllStudents(int size, int page);

    Student getOne(Integer id);

    Student update(Student student, Integer id);
}
