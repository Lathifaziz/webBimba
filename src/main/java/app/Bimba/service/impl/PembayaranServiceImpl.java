package app.Bimba.service.impl;

import app.Bimba.model.Iuran;
import app.Bimba.model.Pembayaran;
import app.Bimba.model.Siswa;
import app.Bimba.repository.PembayaranRepository;
import app.Bimba.service.IuranService;
import app.Bimba.service.PembayaranService;
import app.Bimba.service.SiswaService;
import app.Bimba.util.DTO.PembayaranRequest;
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
    public void bayar(PembayaranRequest request){
        Siswa siswa = siswaService.getOne(request.getSiswa_id());
        Iuran iuran = iuranService.getOne(request.getIuran_id());

        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setSiswa(siswa);
        pembayaran.setIuran(iuran);
        pembayaran.setTanggalPembayaran(LocalDate.now());
        pembayaran.setJumlahPembayaran(request.getJumlah());
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
