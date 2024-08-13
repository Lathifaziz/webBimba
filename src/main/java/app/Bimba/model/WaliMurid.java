package app.Bimba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wali_murid")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaliMurid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_ayah")
    private String namaAyah;

    @Column(name = "nama_ibu")
    private String namaIbu;
    
    @Column(name = "pekerjaan_ayah")
    private String pekerjaanAyah;
    
    @Column(name = "pekerjaan_ibu")
    private String pekerjaanIbu;
    
    @Column(name = "gaji_ayah")
    private Long gajiAyah;
    
    @Column(name = "gaji_ibu")
    private Long gajiIbu;
    
    @Column (name = "birthday_ayah")
    private String birthdayAyah;
    
    @Column (name = "birthday_ibu")
    private String birthdayIbu;



    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
}
