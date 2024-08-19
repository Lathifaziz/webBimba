package app.Bimba.service;

import app.Bimba.model.Pembayaran;
import jakarta.transaction.Transactional;

public interface PembayaranService {

    @Transactional
    void bayar(Integer siswaId, Integer iuranId);

    boolean cekPembayaran(Integer siswaId, Integer id);
}
