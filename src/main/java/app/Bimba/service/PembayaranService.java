package app.Bimba.service;

public interface PembayaranService {


    void bayar(Integer siswaId, Integer iuranId);

    boolean cekPembayaran(Integer siswaId, Integer id);
}
