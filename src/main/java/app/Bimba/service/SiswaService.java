package app.Bimba.service;

import app.Bimba.model.Siswa;

import java.io.IOException;

import app.Bimba.util.DTO.RegisterSiswa;
import app.Bimba.util.DTO.UpdateSiswa;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface SiswaService {
    void create(RegisterSiswa request, MultipartFile file) throws IOException;

    Page<Siswa> getAll(String request, int size, int page);

    Page<Siswa> getAllStudents(int size, int page);

    Siswa getOne(Integer id);

    void update(UpdateSiswa request, Integer id, MultipartFile file) throws IOException;

    void delete(Integer id);
}
