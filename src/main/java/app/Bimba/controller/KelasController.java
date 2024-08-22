package app.Bimba.controller;

import app.Bimba.model.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.Bimba.model.Kelas;
import app.Bimba.service.KelasService;

@Controller
@RequestMapping("/kelas")
public class KelasController {

    @Autowired
    private KelasService kelasService;
    @PostMapping("/save")
    public String save(Kelas request){
        if (request.getName().isBlank()) {
            throw new RuntimeException("tolong masukan nama kelas");
        }
        kelasService.register(request);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getNameByKelas(Model model,
                         @PathVariable("id") Integer id,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String showAll,
                         @RequestParam(defaultValue = "10") int size,
                         @RequestParam(defaultValue = "0") int page) {

        Page<Siswa> siswas;
        if ("true".equals(showAll) || name == null || name.isEmpty()) {
            siswas  = kelasService.getSiswaByKelas(id,null,page,size);
        } else {

            siswas  = kelasService.getSiswa(id,name,page,size);
        }
        Kelas kelasAdd = new Kelas();

        model.addAttribute("kelasAdd", kelasAdd );
        model.addAttribute("siswa", siswas);
        model.addAttribute("name", name);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", siswas.getTotalPages());
        return "datasiswa";
    }

    
    
}
