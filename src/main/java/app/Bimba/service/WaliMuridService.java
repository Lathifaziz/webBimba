package app.Bimba.service;

import app.Bimba.model.WaliMurid;
import app.Bimba.util.DTO.UpdateSiswa;

public interface WaliMuridService {
    WaliMurid create(WaliMurid request);

    WaliMurid update(Integer id, UpdateSiswa request);

    WaliMurid getAll();

    WaliMurid getOne(Integer id);

    void delete(Integer id);
}
