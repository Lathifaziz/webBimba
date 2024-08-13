package app.Bimba.util.DTO;

import app.Bimba.model.Student;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterStudent {

    private String name;

    private Long nik;

    private String birthday;

    private String agama;

    private String address;

    @Size(max = 2)
    private String golonganDarah;

    private Integer anakKe;

    private byte[] photo;

    private String namaAyah;

    private String birthdayAyah;

    private String birthdayIbu;

    private String namaIbu;

    private String pekerjaanAyah;

    private String pekerjaanIbu;

    private Long gajiAyah;

    private Long gajiIbu;

    private Student student;
}
