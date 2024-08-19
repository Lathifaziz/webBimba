package app.Bimba.service.impl;

import app.Bimba.model.Iuran;
import app.Bimba.model.Pembayaran;
import app.Bimba.model.Siswa;
import app.Bimba.repository.PembayaranRepository;
import app.Bimba.service.IuranService;
import app.Bimba.service.PembayaranService;
import app.Bimba.service.SiswaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PembayaranServiceImpl implements PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;

    @Autowired
    private IuranService iuranService;

    @Autowired
    private SiswaService siswaService;

    @Transactional
    @Override
    public void bayar(Integer siswaId, Integer iuranId){
       Siswa siswa = siswaService.getOne(siswaId);
       Iuran iuran = iuranService.getOne(iuranId);


        if (siswa == null || siswa.getName().isEmpty()) {
            throw new IllegalArgumentException("Siswa tidak ditemukan");
        }
        if (iuran == null) {
            throw new IllegalArgumentException("Iuran tidak ditemukan");
        }
        // Cek apakah sudah ada pembayaran untuk iuran ini
        Optional<Pembayaran> pembayaranOpt = pembayaranRepository.findBySiswaAndIuran(siswa, iuran);
        if (pembayaranOpt.isPresent()) {
            throw new IllegalStateException("Pembayaran untuk iuran ini sudah dilakukan");
        }

        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setSiswa(siswa);
        pembayaran.setIuran(iuran);
        pembayaran.setJumlahPembayaran(iuran.getJumlah());
        pembayaran.setTanggalPembayaran(LocalDate.now());
        pembayaranRepository.save(pembayaran);

    }

    @Override
    public boolean cekPembayaran(Integer siswaId, Integer iuranId) {
        Siswa siswa = siswaService.getOne(siswaId);
        Iuran iuran = iuranService.getOne(iuranId);

        if (siswa == null || iuran == null) {
            return false;
        }

        // Cek apakah sudah ada pembayaran untuk siswa dan iuran ini
        Optional<Pembayaran> pembayaranOpt = pembayaranRepository.findBySiswaAndIuran(siswa, iuran);

        // Jika ada pembayaran, berarti sudah membayar
        return pembayaranOpt.isPresent();
    }

}
