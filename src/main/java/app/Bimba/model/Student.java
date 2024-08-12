package app.Bimba.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String nik;

    private String birthday;
    
    private String agama;
    
    private String address;

    @Column(name = "gol_darah")
    private String golonganDarah;


    @Column(name = "anak_ke")
    private Integer anakKe;
    
    @Lob
    private byte[] photo;

    
}