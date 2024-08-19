package app.Bimba.controller;

import app.Bimba.model.Iuran;
import app.Bimba.service.IuranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/iuran")
public class IuranController {

    @Autowired
    private IuranService iuranService;

    @PostMapping
    public void create(Iuran request){
        iuranService.create(request);
    }

    @GetMapping
    public List<Iuran> getAll(){
        return iuranService.getAll();
    }
    @DeleteMapping
    public void delete(@PathVariable Integer id){
        iuranService.delete(id);
    }

}
