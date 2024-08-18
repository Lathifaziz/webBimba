package app.Bimba.service.impl;

import app.Bimba.model.WaliMurid;
import app.Bimba.repository.WaliMuridRepository;
import app.Bimba.service.WaliMuridService;
import app.Bimba.util.DTO.UpdateSiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WaliMuridServiceImpl implements WaliMuridService {

    @Autowired
    private WaliMuridRepository waliMuridRepository;

   
    @Override
    public WaliMurid create(WaliMurid request) {
        return waliMuridRepository.save(request);
    }

    @Override
    public WaliMurid update(Integer id, UpdateSiswa request) {
        WaliMurid waliMurid = waliMuridRepository.findById(id).orElseThrow(
             () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Wali Murid tidak ditemukan")
        );
        waliMurid.setNamaAyah(request.getNamaAyah());
        waliMurid.setNamaIbu(request.getNamaIbu());
        waliMurid.setBirthdayAyah(request.getBirthdayAyah());
        waliMurid.setBirthdayIbu(request.getBirthdayIbu());
        waliMurid.setPekerjaanAyah(request.getPekerjaanAyah());
        waliMurid.setPekerjaanIbu(request.getPekerjaanIbu());
        waliMurid.setGajiAyah(request.getGajiAyah());
        waliMurid.setGajiIbu(request.getGajiIbu());
        return waliMuridRepository.save(waliMurid);
    }

    @Override
    public WaliMurid getAll() {
        return null;
    }

    @Override
    public WaliMurid getOne(Integer id) {
        return waliMuridRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        waliMuridRepository.deleteById(id);
    }
}
