package com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.partidos;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.IPartidosRepository;
import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Partidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartidosServices implements IPartidosService {

    @Autowired
    private IPartidosRepository partidosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Partidos> findAll() {
        return partidosRepository.findAll();
    }

    @Override
    public Partidos findById(Long id) {
        return partidosRepository.findById(id).orElse(null);
    }

    @Override
    public Partidos save(Partidos partidos) {
        return partidosRepository.save(partidos);
    }

    @Override
    public void deleteById(Long id) {
        partidosRepository.deleteById(id);
    }
}

