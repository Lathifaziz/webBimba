package app.Bimba.controller;

import app.Bimba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import app.Bimba.model.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

//@RestController
@RequestMapping("/students")
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/save")
    public String create(Model model, Student request) {
            studentService.create(request);

        model.addAttribute("siswa", studentService.getAll(request));
        return "redirect:/students/datasiswa";
    }

    @GetMapping("/siswa")
    public String add(Model model) {
        model.addAttribute("siswa", new Student());
        return "siswa";
    }

    @GetMapping("/datasiswa")
    public String getAll(Model model, Student student) {
        model.addAttribute("siswa", studentService.getAll(student));
        return "datasiswa";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") Integer id , Model model){
        Student student = studentService.getOne(id);
        model.addAttribute("bio", student);
        return "biodata";
    }


}
