package com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.apuestas;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.IApuestasRepository;
import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Apuestas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApuestasService implements IApuestasService {

    @Autowired
    private IApuestasRepository apuestasRepository;

    @Override
    public List<Apuestas> findAll() {
        return apuestasRepository.findAll();
    }

    @Override
    public Apuestas findById(Long id) {
        return apuestasRepository.findById(id).orElse(null);
    }

    @Override
    public Apuestas save(Apuestas apuestas) {
        return apuestasRepository.save(apuestas);
    }

    @Override
    public void deleteById(Long id) {
        apuestasRepository.deleteById(id);
    }
}
