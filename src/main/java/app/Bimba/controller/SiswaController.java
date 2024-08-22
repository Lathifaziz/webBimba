package app.Bimba.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import app.Bimba.model.Kelas;
import app.Bimba.model.Siswa;
import app.Bimba.model.WaliMurid;
import app.Bimba.service.KelasService;
import app.Bimba.service.SiswaService;
import app.Bimba.service.WaliMuridService;
import app.Bimba.util.DTO.RegisterSiswa;
import app.Bimba.util.DTO.UpdateSiswa;


@RequestMapping("/students")
@Controller
public class SiswaController {
    @Autowired
    private SiswaService siswaService;

    @Autowired
    private WaliMuridService waliMuridService;

    @Autowired
    private KelasService kelasService;

    @PostMapping("/save")
    public String register(RegisterSiswa request,MultipartFile file) throws IOException {

        siswaService.create(request,file);
        return "redirect:/";
    }

    @GetMapping("/form")
    public String add(Model model) {
        List<Kelas> kelas = kelasService.getAll();
        if (kelas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"silahkan buat kelas");
        }

        model.addAttribute("kelas", kelas);
        model.addAttribute("siswa", new RegisterSiswa());
        return "form";
    }

    @GetMapping("/datasiswa")
    public String getAll(Model model,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String showAll,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "0") int page) {

        Page<Siswa> students;

        if ("true".equals(showAll) || name == null || name.isEmpty()) {
            students = siswaService.getAllStudents(page, size);
        } else {

            students = siswaService.getAll(name, page, size);
        }
        Kelas kelas = new Kelas();

        model.addAttribute("kelas", kelas );
        model.addAttribute("siswa", students);
        model.addAttribute("name", name);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", students.getTotalPages());
        return "datasiswa";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Integer id, Model model) {

        Siswa siswa = siswaService.getOne(id);
        WaliMurid waliMurid = waliMuridService.getOne(id);

        byte[] photo = siswa.getPhoto();
        String photoBase64 = Base64.getEncoder().encodeToString(photo);
        model.addAttribute("bio", siswa);
        model.addAttribute("new",waliMurid);
        model.addAttribute("photoBase64", photoBase64);
        return "biodata";
    }

    @PostMapping("/{id}/update")
    public String updateStudent(@PathVariable("id") Integer id,
        UpdateSiswa request,
          MultipartFile file,Model model) throws IOException 
        {
            waliMuridService.update(id, request);
            siswaService.update(request, id,file);
        return "redirect:/students/{id}";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id){

        if (siswaService.getOne(id) != null){
            waliMuridService.delete(id);
            siswaService.delete(id);
        }else {
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND,"Tidak menemukan id");
        }
        return "redirect:/students/datasiswa";
    }
    

}
