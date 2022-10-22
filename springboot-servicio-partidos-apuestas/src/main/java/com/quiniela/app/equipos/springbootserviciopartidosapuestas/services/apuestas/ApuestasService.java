package com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.apuestas;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.IApuestasRepository;
import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Apuestas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApuestasService implements IApuestasService{

    @Autowired
    IApuestasRepository apuestaDao;

    @Override
    public List<Apuestas> findAll() {
        return this.apuestaDao.findAll();
    }

    @Override
    public Apuestas findById(Long id) {
        return this.apuestaDao.findById(id).orElse(null);
    }
}
