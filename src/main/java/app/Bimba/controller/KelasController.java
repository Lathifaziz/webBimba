package app.Bimba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import app.Bimba.model.Kelas;
import app.Bimba.service.KelasService;

@Controller
@RequestMapping("/kelas")
public class KelasController {

    @Autowired
    private KelasService kelasService;

    @GetMapping("/get")
    public void getAll(Model model){
        model.addAttribute( "kelasGet" , new Kelas());
    }

    @PostMapping("/save")
    public String save(Kelas request){
        if (request.getName().isBlank()) {
            throw new RuntimeException("tolong masukan nama kelas");
        }
        kelasService.register(request);
        return "redirect:/students/datasiswa";
    }
    
    
}
