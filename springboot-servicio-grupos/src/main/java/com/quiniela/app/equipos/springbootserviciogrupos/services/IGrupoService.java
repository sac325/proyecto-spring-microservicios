package com.quiniela.app.equipos.springbootserviciogrupos.services;

import com.quiniela.app.commons.models.entity.Grupo;
import com.quiniela.app.equipos.springbootserviciogrupos.models.dto.GrupoDto;

import java.util.List;

public interface IGrupoService {
    List<Grupo> findAll();

    GrupoDto findById(Long id);

    GrupoDto save(GrupoDto grupoDto);

    void deleteById(Long id);
}

