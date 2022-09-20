package com.quiniela.app.equipos.springbootserviciogrupos.models.dao.imagengrupos;

import com.quiniela.app.commons.models.entity.ImagenGrupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagenGruposRepository extends JpaRepository<ImagenGrupos, Long> {
}
