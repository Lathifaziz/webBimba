package app.Bimba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="siswa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Long nik;

    private String birthday;
    
    private String agama;
    
    private String address;

    @Column(name = "gol_darah")
    private String golonganDarah;


    @Column(name = "anak_ke")
    private Integer anakKe;
    
    @Lob
    private byte[] photo;

    @OneToOne(mappedBy = "siswa", fetch = FetchType.LAZY)
    private WaliMurid waliMurid;

    @ManyToOne
    @JoinColumn(name = "kelas_id")
    private Kelas kelas;
    
}