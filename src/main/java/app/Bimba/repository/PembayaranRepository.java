package app.Bimba.repository;

import app.Bimba.model.Iuran;
import app.Bimba.model.Pembayaran;
import app.Bimba.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran,Integer> {

    Optional<Pembayaran> findBySiswaAndIuran(Siswa siswa, Iuran iuran);
}
