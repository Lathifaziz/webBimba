package app.Bimba.service;

import app.Bimba.util.DTO.PembayaranRequest;
import jakarta.transaction.Transactional;

public interface PembayaranService {

    @Transactional
    void bayar(PembayaranRequest request);

    boolean cekPembayaran(Integer siswaId, Integer id);
}
