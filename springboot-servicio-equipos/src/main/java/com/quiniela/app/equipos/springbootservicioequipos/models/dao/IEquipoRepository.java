package com.quiniela.app.equipos.springbootservicioequipos.models.dao;

import com.quiniela.app.commons.models.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoRepository extends JpaRepository<Equipo, Long> {
}
