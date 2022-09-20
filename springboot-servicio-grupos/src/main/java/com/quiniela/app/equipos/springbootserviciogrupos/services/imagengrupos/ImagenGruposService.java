package com.quiniela.app.equipos.springbootserviciogrupos.services.imagengrupos;

import com.quiniela.app.commons.models.entity.ImagenGrupos;
import com.quiniela.app.equipos.springbootserviciogrupos.models.dao.imagengrupos.IImagenGruposRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImagenGruposService implements IImagenGruposService {

    @Autowired
    private IImagenGruposRepository equipoDao;

    @Override
    @Transactional(readOnly = true)
    public List<ImagenGrupos> findAll() {
        return equipoDao.findAll();
    }

    @Override
    public ImagenGrupos findById(Long id) {
        return equipoDao.findById(id).orElse(null);
    }
}
