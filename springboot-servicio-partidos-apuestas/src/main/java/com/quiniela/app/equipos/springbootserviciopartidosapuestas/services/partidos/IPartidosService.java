package com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.partidos;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Partidos;

import java.util.List;

public interface IPartidosService {
    List<Partidos> findAll();

    Partidos findById(Long id);

    Partidos save(Partidos partidos);

    void deleteById(Long id);
}

