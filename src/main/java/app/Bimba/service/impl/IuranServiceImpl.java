package app.Bimba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import app.Bimba.model.Iuran;
import app.Bimba.repository.IuranRepository;
import app.Bimba.service.IuranService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IuranServiceImpl implements IuranService {

    @Autowired
    private IuranRepository iuranRepository;

    @Override
    public void create(Iuran request) {
            Iuran iuran = new Iuran();
            iuran.setBulan(request.getBulan());
            iuran.setJumlah(request.getJumlah());
            iuranRepository.save(iuran);
    }

    @Override
    public List<Iuran> getAll() {
    return iuranRepository.findAll();
    }

    @Override
    public Iuran getOne(Integer id){
        return iuranRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Iuran tidak ditemukan")
        );
    }

    @Override
    public void delete(Integer id) {
        iuranRepository.deleteById(id);
    }

}
