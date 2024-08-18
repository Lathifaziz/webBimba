package app.Bimba.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kelas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kelas {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    
}
