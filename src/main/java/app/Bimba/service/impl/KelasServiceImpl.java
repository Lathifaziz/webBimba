package app.Bimba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Bimba.model.Kelas;
import app.Bimba.repository.KelasRepository;
import app.Bimba.service.KelasService;

@Service
public class KelasServiceImpl implements KelasService {

    @Autowired
    private KelasRepository kelasRepository;

    @Override
    public void register(Kelas kelas){
        if (kelas.getName().isBlank()) {
            throw new RuntimeException("tolong masukan nama kelas");
        }
        kelas.setName(kelas.getName());
        kelasRepository.save(kelas);
    }
    @Override
    public List<Kelas> getAll(){
        return kelasRepository.findAll();
    }
    @Override
    public List<Kelas> getByName(String name){
        return kelasRepository.findByName(name);
    }
    @Override
    public List<String> getKelasNames(String name) {
        return kelasRepository.findNameKelas();
    }
    
    
}
