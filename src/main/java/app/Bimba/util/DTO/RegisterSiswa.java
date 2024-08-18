package app.Bimba.util.DTO;

import app.Bimba.model.Siswa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterSiswa {

    @NotBlank
    private String name;
    @NotBlank
    private Long nik;
    @NotBlank
    private String birthday;

    private String agama;
    @NotBlank
    private String address;

    @Size(max = 2)
    private String golonganDarah;

    private Integer anakKe;

    private byte[] photo;
    @NotBlank
    private String namaAyah;

    private String birthdayAyah;

    private String birthdayIbu;
    @NotBlank
    private String namaIbu;

    private String pekerjaanAyah;

    private String pekerjaanIbu;

    private Long gajiAyah;

    private Long gajiIbu;
    @NotBlank
    private String kelas;

    private Siswa siswa;
}
