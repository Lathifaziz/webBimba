package app.Bimba.service;

import app.Bimba.model.Student;

import java.util.List;

public interface StudentService {
    Student create(Student request);
    List<Student> getAll(Student request);

    Student getOne(Integer id);

    Student update(Student student, Integer id);
}
