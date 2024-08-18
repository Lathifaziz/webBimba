package app.Bimba.repository;

import app.Bimba.model.Iuran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IuranRepository extends JpaRepository<Iuran,Integer> {

    Optional<Iuran> findByBulan(String bulan);
}
