package com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Partidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidosRepository extends JpaRepository<Partidos, Long> {
}
