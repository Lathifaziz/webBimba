package app.Bimba.service.impl;

import java.io.IOException;
import app.Bimba.service.KelasService;
import app.Bimba.service.WaliMuridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import app.Bimba.model.Kelas;
import app.Bimba.model.Siswa;
import app.Bimba.model.WaliMurid;
import app.Bimba.repository.SiswaRepository;
import app.Bimba.service.SiswaService;
import app.Bimba.util.DTO.RegisterSiswa;
import app.Bimba.util.DTO.UpdateSiswa;
import app.Bimba.util.Specification.SearchStudent;

@Service
public class SiswaServiceImpl implements SiswaService {

    @Autowired
    private SiswaRepository siswaRepository;

    @Autowired
    private WaliMuridService waliMuridService;

    @Autowired
    private KelasService kelasService;

    @Override
    public void create(RegisterSiswa request,MultipartFile file) throws IOException {

        if (request.getName().isEmpty()){
            throw new RuntimeException("Tolong masukan Nama");
        }
        if (request.getKelas() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tolong masukan kelas");
        }
        if (request.getNik() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tolong masukan Nomor Induk");
        }
        if (request.getAddress() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tolong masukan Alamat");
        }
        
        Kelas kelas = kelasService.getOne(request.getKelas());

        Siswa siswa = new Siswa();
        siswa.setName(request.getName());
        siswa.setNik(request.getNik());
        siswa.setGolonganDarah(request.getGolonganDarah());
        siswa.setBirthday(request.getBirthday());
        siswa.setAgama(request.getAgama());
        siswa.setAnakKe(request.getAnakKe());
        siswa.setAddress(request.getAddress());
        siswa.setPhoto(file.getBytes());
        siswa.setKelas(kelas);
        siswaRepository.save(siswa);

        WaliMurid waliMurid = new WaliMurid();
        waliMurid.setSiswa(siswa);
        waliMurid.setNamaIbu(request.getNamaIbu());
        waliMurid.setBirthdayAyah(request.getBirthdayAyah());
        waliMurid.setBirthdayIbu(request.getBirthdayIbu());
        waliMurid.setNamaAyah(request.getNamaAyah());
        waliMurid.setPekerjaanIbu(request.getPekerjaanIbu());
        waliMurid.setPekerjaanAyah(request.getPekerjaanAyah());
        waliMurid.setGajiIbu(request.getGajiIbu());
        waliMurid.setGajiAyah(request.getGajiAyah());
        waliMuridService.create(waliMurid);
    }

    @Override
    public Page<Siswa> getAll(String request, int size, int page) {
        Pageable pageable = PageRequest.of(size, page);

        Specification<Siswa> spec = SearchStudent.nameContent(request);

        return siswaRepository.findAll(spec, pageable);
    }

    @Override
    public Page<Siswa> getAllStudents(int size, int page) {
        Pageable pageable = PageRequest.of(size, page);
        return siswaRepository.findAll(pageable);
    }

    @Override
    public Siswa getOne(Integer id) {
        return siswaRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(UpdateSiswa request, Integer id, MultipartFile file) throws IOException {
        Siswa siswa = siswaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id " + id + " not found"));

        if (request.getName() != null) {
            siswa.setName(request.getName());
        }
        if (request.getNik() != 0) {
            siswa.setNik(request.getNik());
        }
        if (request.getGolonganDarah() != null){
            siswa.setGolonganDarah(request.getGolonganDarah());
        }
        if (request.getBirthday() != null) {
            siswa.setBirthday(request.getBirthday());
        }
        if (request.getAnakKe() != null) {
            siswa.setAnakKe(request.getAnakKe());
        }
        if (request.getAgama() != null) {
            siswa.setAgama(request.getAgama());
        }
        if (request.getAddress() != null) {
            siswa.setAddress(request.getAddress());
        }
        if (request.getPhoto() != null) {
            siswa.setPhoto(file.getBytes());
        }
        siswaRepository.save(siswa);

    }

    @Override
    public void delete(Integer id) {
        siswaRepository.deleteById(id);
    }

}
