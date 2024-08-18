package app.Bimba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "iuran")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Iuran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String bulan;

    private Double jumlah;
}
