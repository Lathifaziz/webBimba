package app.Bimba.service;

import java.util.List;

import app.Bimba.model.Kelas;
import app.Bimba.model.Siswa;
import org.springframework.data.domain.Page;

public interface KelasService {
 
    void register(Kelas kelas);

    public List<Kelas> getAll();

    Page<Siswa> getSiswaByKelas(Integer kelasId,String name, int page,int size);


    Page<Siswa> getSiswa(Integer kelasId, String name, int page, int size);

    Kelas getOne(Integer id);

    List<String> getKelasNames(String name);

    List<Kelas> getByName(String name);
}
