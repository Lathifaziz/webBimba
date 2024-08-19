package app.Bimba.service;

import java.util.List;

import app.Bimba.model.Kelas;

public interface KelasService {
 
    void register(Kelas kelas);

    public List<Kelas> getAll();

    List<String> getKelasNames(String name);

    List<Kelas> getByName(String name);
}
