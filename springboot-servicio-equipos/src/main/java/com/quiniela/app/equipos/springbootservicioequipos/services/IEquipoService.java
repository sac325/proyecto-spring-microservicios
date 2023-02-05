package com.quiniela.app.equipos.springbootservicioequipos.services;

import com.quiniela.app.commons.models.entity.Equipo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEquipoService {

    public List<Equipo> findAll();

    public Page<Equipo> findAll(Pageable pageable);

    public Equipo findById(Long id);
    
    public Equipo save(Equipo equipo);
    
    public void deleteById(Long id);
}
