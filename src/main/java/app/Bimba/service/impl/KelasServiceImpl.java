package app.Bimba.service.impl;

import java.util.List;

import app.Bimba.model.Siswa;
import app.Bimba.repository.SiswaRepository;
import app.Bimba.util.Specification.SearchStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import app.Bimba.model.Kelas;
import app.Bimba.repository.KelasRepository;
import app.Bimba.service.KelasService;

@Service
public class KelasServiceImpl implements KelasService {

    @Autowired
    private KelasRepository kelasRepository;

    @Autowired
    private SiswaRepository siswaRepository;

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
    @Override
    public Page<Siswa> getSiswaByKelas(Integer kelasId,String name, int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return siswaRepository.findByKelasId(kelasId,pageable);
    }
    @Override
    public Page<Siswa> getSiswa(Integer kelasId, String name, int page, int size) {
        Specification<Siswa> spec = Specification.where(SearchStudent.hasKelasId(kelasId))
                .and(SearchStudent.nameContent(name));

        return siswaRepository.findAll(spec, PageRequest.of(page, size));
    }
    @Override
    public Kelas getOne(Integer id) {
       return kelasRepository.findById(id).orElseThrow(
        ()-> new RuntimeException("tidak ada kelas tersebut")
       );
    }
    
    
}
