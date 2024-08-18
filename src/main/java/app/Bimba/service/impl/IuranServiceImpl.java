package app.Bimba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Bimba.model.Iuran;
import app.Bimba.repository.IuranRepository;
import app.Bimba.service.IuranService;

@Service
public class IuranServiceImpl implements IuranService {

    @Autowired
    private IuranRepository iuranRepository;

    @Override
    public void create(Iuran request) {
            Iuran iuran = new Iuran();
            // iuran.setBulan(System.currentTimeMillis());
    }

    @Override
    public List<Iuran> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
