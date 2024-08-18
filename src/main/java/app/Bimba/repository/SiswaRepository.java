package app.Bimba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import app.Bimba.model.Kelas;
import app.Bimba.model.Siswa;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa,Integer> ,JpaSpecificationExecutor<Siswa>{
     List<Siswa> findByKelas(Kelas kelas);
    
} 
