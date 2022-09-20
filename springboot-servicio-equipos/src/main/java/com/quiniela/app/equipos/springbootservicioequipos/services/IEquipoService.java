package com.quiniela.app.equipos.springbootservicioequipos.services;

import com.quiniela.app.commons.models.entity.Equipo;

import java.util.List;

public interface IEquipoService {

    List<Equipo> findAll();

    Equipo findById(Long id);
}
