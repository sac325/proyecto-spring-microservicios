package com.quiniela.app.equipos.springbootserviciogrupos.models.dao;

import com.quiniela.app.commons.models.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrupoDao extends JpaRepository<Grupo, Long> {
}
