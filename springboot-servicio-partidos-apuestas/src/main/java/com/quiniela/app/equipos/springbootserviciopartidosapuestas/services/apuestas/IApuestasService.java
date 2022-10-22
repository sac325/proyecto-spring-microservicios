package com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.apuestas;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Apuestas;

import java.util.List;

public interface IApuestasService {

    List<Apuestas> findAll();

    Apuestas findById(Long id);
}
