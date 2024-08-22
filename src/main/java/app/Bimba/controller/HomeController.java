package app.Bimba.controller;

import app.Bimba.model.Kelas;
import app.Bimba.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    private KelasRepository kelasService;

    @GetMapping
    public String welcome(Model model){
        List<Kelas> kelas = kelasService.findAll();
        Kelas kelasAdd = new Kelas();
        model.addAttribute("kelasGet", kelas);
        model.addAttribute("kelasAdd", kelasAdd);
        return "index";

    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }




}
