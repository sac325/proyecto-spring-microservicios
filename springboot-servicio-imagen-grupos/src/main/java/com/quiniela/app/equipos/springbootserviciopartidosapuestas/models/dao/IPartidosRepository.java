package com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidosRepository extends JpaRepository<Partidos, Long> {
}
