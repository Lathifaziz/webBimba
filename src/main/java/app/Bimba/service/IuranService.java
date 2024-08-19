package app.Bimba.service;

import java.util.List;

import app.Bimba.model.Iuran;

public interface IuranService {
    
    void create(Iuran request);

    List<Iuran> getAll();

    Iuran getOne(Integer id);

    void delete(Integer id);
}
