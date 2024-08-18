package app.Bimba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.Bimba.model.Kelas;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Integer> {
    List<Kelas> findByName(String name);

    @Query("SELECT DISTINCT k.name FROM Kelas as k")
    List<String> findNameKelas();

}
