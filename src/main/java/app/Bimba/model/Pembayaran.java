package app.Bimba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "pembayaran")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Iuran iuran;

    @ManyToOne
    private Siswa siswa;

    @Column(name = "tanggal_pembayaran")
    private LocalDate tanggalPembayaran;

    @Column(name = "jumlah_pembayaran")
    private BigInteger jumlahPembayaran;
}
