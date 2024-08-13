package app.Bimba.controller;

import app.Bimba.service.StudentService;
import app.Bimba.util.DTO.RegisterStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import app.Bimba.model.Student;
import app.Bimba.model.WaliMurid;

import java.io.IOException;
import java.util.Base64;
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
    public String create(Model model, RegisterStudent request, MultipartFile file) throws IOException {
        studentService.create(request, file);
        model.addAttribute("siswa", "create success");
        return "redirect:/students/datasiswa";
    }

    @GetMapping("/siswa")
    public String add(Model model) {
        model.addAttribute("siswa", new RegisterStudent());
        return "siswa";
    }

    @GetMapping("/datasiswa")
    public String getAll(Model model,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String showAll,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "0") int page) {

        Page<Student> students;

        if ("true".equals(showAll) || name == null || name.isEmpty()) {
            students = studentService.getAllStudents(page,size);
        } else {

            students = studentService.getAll(name,page,size);
        }

        model.addAttribute("siswa", students);
        model.addAttribute("name", name);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", students.getTotalPages());
        return "datasiswa";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") Integer id, Model model) {

        Student student = studentService.getOne(id);

        byte[] photo = student.getPhoto();
        String photoBase64 = Base64.getEncoder().encodeToString(photo);
        model.addAttribute("bio", student);
        model.addAttribute("photoBase64", photoBase64);
        return "biodata";
    }

}
