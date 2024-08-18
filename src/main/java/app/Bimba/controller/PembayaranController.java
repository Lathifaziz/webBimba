package app.Bimba.controller;

import app.Bimba.model.Iuran;
import app.Bimba.model.Siswa;
import app.Bimba.repository.IuranRepository;
import app.Bimba.repository.SiswaRepository;
import app.Bimba.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/pembayaran")
public class PembayaranController {

    @Autowired
    private PembayaranService pembayaranService;

    @Autowired
    private SiswaRepository siswaRepository;

    @Autowired
    private IuranRepository iuranRepository;

    // Endpoint untuk menampilkan halaman cek pembayaran
    @GetMapping("/cek")
    public String cekPembayaran(
            @RequestParam("siswaId") Integer siswaId,
            @RequestParam("bulan") String bulan,
            Model model) {

        Optional<Siswa> siswaOpt = siswaRepository.findById(siswaId);
        if (siswaOpt.isEmpty()) {
            model.addAttribute("error", "Siswa tidak ditemukan");
            return "error";
        }

        Siswa siswa = siswaOpt.get();
        // Misalnya, iuran sudah didefinisikan berdasarkan bulan
        Optional<Iuran> iuranOpt = iuranRepository.findByBulan(bulan);

        if (iuranOpt.isEmpty()) {
            model.addAttribute("error", "Iuran untuk bulan ini tidak ditemukan");
            return "error";
        }

        Iuran iuran = iuranOpt.get();

        boolean sudahBayar = pembayaranService.cekPembayaran(siswaId, iuran.getId());
        model.addAttribute("siswa", siswa);
        model.addAttribute("bulan", bulan);
        model.addAttribute("sudahBayar", sudahBayar);
        return "cek-pembayaran";
    }

    // Endpoint untuk memproses pembayaran
    @PostMapping("/bayar")
    public String prosesPembayaran(
            @RequestParam("siswaId") Integer siswaId,
            @RequestParam("iuranId") Integer iuranId,
            @RequestParam("bulan") String bulan,
            RedirectAttributes redirectAttributes) {

        try {
            pembayaranService.bayar(siswaId, iuranId);
            redirectAttributes.addFlashAttribute("success", "Pembayaran berhasil diproses");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/pembayaran/cek?siswaId=" + siswaId + "&bulan=" +  bulan ;
    }
}

