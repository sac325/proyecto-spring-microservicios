package com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Apuestas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApuestasRepository extends JpaRepository<Apuestas,Long> {
}
