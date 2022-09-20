package com.quiniela.app.equipos.springbootserviciogrupos.services.imagengrupos;

import com.quiniela.app.commons.models.entity.ImagenGrupos;

import java.util.List;

public interface IImagenGruposService {

    List<ImagenGrupos> findAll();

    ImagenGrupos findById(Long id);
}
