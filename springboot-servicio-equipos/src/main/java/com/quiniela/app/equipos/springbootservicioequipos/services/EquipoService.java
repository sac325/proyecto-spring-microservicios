package com.quiniela.app.equipos.springbootservicioequipos.services;

import com.quiniela.app.commons.models.entity.Equipo;
import com.quiniela.app.equipos.springbootservicioequipos.models.dao.IEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipoService implements IEquipoService{

    @Autowired
    private IEquipoRepository equipoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Equipo> findAll() {
        return equipoDao.findAll();
    }

    @Override
    public Equipo findById(Long id) {
        return equipoDao.findById(id).orElse(null);
    }

	@Override
	public Equipo save(Equipo equipo) { 
		return equipoDao.save(equipo);
	}

	@Override
	public void deleteById(Long id) {
//		Equipo equipo = equipoDao.getById(id);
		equipoDao.deleteById(id);
		
	}
    
    
}
