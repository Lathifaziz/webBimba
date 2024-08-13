package app.Bimba.service.impl;

import app.Bimba.model.WaliMurid;
import app.Bimba.repository.WaliMuridRepository;
import app.Bimba.util.DTO.RegisterStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import app.Bimba.model.Student;
import app.Bimba.repository.StudentRepository;
import app.Bimba.service.StudentService;
import app.Bimba.util.Specification.SearchStudent;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private WaliMuridRepository waliMuridRepository;


    @Override
    public void create(RegisterStudent request, MultipartFile file) throws IOException {
        Student student = new Student();
        student.setName(request.getName());
        student.setNik(request.getNik());
        student.setGolonganDarah(request.getGolonganDarah());
        student.setBirthday(request.getBirthday());
        student.setAgama(request.getAgama());
        student.setAnakKe(request.getAnakKe());
        student.setAddress(request.getAddress());
        student.setPhoto(file.getBytes());
        studentRepository.save(student);

        WaliMurid waliMurid = new WaliMurid();
        waliMurid.setStudent(student);
        waliMurid.setNamaIbu(request.getNamaIbu());
        waliMurid.setBirthdayAyah(request.getBirthdayAyah());
        waliMurid.setBirthdayIbu(request.getBirthdayIbu());
        waliMurid.setNamaAyah(request.getNamaAyah());
        waliMurid.setPekerjaanIbu(request.getPekerjaanIbu());
        waliMurid.setPekerjaanAyah(request.getPekerjaanAyah());
        waliMurid.setGajiIbu(request.getGajiIbu());
        waliMurid.setGajiAyah(request.getGajiAyah());
        waliMuridRepository.save(waliMurid);
    }

    @Override
    public Page<Student> getAll(String request,int size,int page) {
        Pageable pageable = PageRequest.of(size, page);

        Specification<Student> spec = SearchStudent.nameContent(request);

    return studentRepository.findAll(spec, pageable);
    }

    @Override
    public Page<Student> getAllStudents(int size, int page){
        Pageable pageable = PageRequest.of(size, page);
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getOne(Integer id){
        return studentRepository.findById(id).orElseThrow();
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
