package app.Bimba.service.impl;

import app.Bimba.model.Student;
import app.Bimba.model.WaliMurid;
import app.Bimba.repository.StudentRepository;
import app.Bimba.repository.WaliMuridRepository;
import app.Bimba.service.StudentService;
import app.Bimba.service.WaliMuridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaliMuridServiceImpl implements WaliMuridService {

    @Autowired
    private WaliMuridRepository waliMuridRepository;

    @Autowired
    private StudentService studentService;

    @Override
    public WaliMurid create(WaliMurid request) {
        return waliMuridRepository.save(request);
    }

    @Override
    public WaliMurid update(Integer id, WaliMurid request) {
        return null;
    }

    @Override
    public WaliMurid getAll() {
        return null;
    }

    @Override
    public WaliMurid getOne(Integer id, WaliMurid request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
