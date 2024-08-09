package app.Bimba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import app.Bimba.model.Student;
import app.Bimba.repository.StudentRepository;
import app.Bimba.service.StudentService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student request) {
       return studentRepository.save(request);
    }

    @Override
    public List<Student> getAll(Student request) {
    return studentRepository.findAll();
    }

    @Override
    public Student getOne(Integer id){
        return studentRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"id tidak ada")
        );
    }
    @Override
    public Student update(Student student, Integer id){
        Student student1 = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tidak ada")
        );
        student1.setName(student.getName());
        student1.setNik(student.getNik());
        student1.setBirthday(student.getBirthday());
        student1.setAddress(student.getAddress());
        return studentRepository.save(student1);

    }

}
