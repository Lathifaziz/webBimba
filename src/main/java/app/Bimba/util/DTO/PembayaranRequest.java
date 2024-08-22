package app.Bimba.util.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PembayaranRequest {
    
    private Integer siswa_id;

    private Integer iuran_id;

    private String bulan;

    private Long jumlah;

}
