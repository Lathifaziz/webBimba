package app.Bimba.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import app.Bimba.model.Siswa;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa,Integer> ,JpaSpecificationExecutor<Siswa>{
     Page<Siswa> findByKelasId(Integer kelasId,Pageable pageable);

}
