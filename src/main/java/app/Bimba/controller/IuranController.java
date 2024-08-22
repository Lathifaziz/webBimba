package app.Bimba.controller;

import app.Bimba.model.Iuran;
import app.Bimba.model.Siswa;
import app.Bimba.repository.SiswaRepository;
import app.Bimba.service.IuranService;
import app.Bimba.util.DTO.PembayaranRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iuran")
public class IuranController {

    @Autowired
    private IuranService iuranService;
    @Autowired
    private SiswaRepository siswaService;

    @PostMapping
    public void create(Iuran request){
        iuranService.create(request);
    }

    @GetMapping
    public String getAll(Model model){
        List<Siswa> siswa = siswaService.findAll();
        List<Iuran> iurans = iuranService.getAll();

        model.addAttribute("addIuran", iurans);
        model.addAttribute("siswa", siswa);
        model.addAttribute("iuran", new PembayaranRequest());
        return "iuran";
    }
    
    @DeleteMapping
    public void delete(@PathVariable Integer id){
        iuranService.delete(id);
    }

}
