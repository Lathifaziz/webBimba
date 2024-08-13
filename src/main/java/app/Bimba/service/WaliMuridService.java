package app.Bimba.service;

import app.Bimba.model.WaliMurid;

public interface WaliMuridService {
    WaliMurid create(WaliMurid request);

    WaliMurid update(Integer id,WaliMurid request);

    WaliMurid getAll();

    WaliMurid getOne(Integer id,WaliMurid request);

    void delete(Integer id);
}
