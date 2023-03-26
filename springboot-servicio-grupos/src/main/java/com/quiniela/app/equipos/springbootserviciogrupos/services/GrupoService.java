package com.quiniela.app.equipos.springbootserviciogrupos.services;

import com.quiniela.app.commons.models.entity.Equipo;
import com.quiniela.app.commons.models.entity.Grupo;
import com.quiniela.app.equipos.springbootserviciogrupos.clientes.EquipoClienteRest;
import com.quiniela.app.equipos.springbootserviciogrupos.models.dao.IGrupoDao;
import com.quiniela.app.equipos.springbootserviciogrupos.models.dto.GrupoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class GrupoService implements IGrupoService {

    @Autowired
    private IGrupoDao grupoDao;

    @Autowired
    EquipoClienteRest equipos;

    @Override
    @Transactional(readOnly = true)
    public List<Grupo> findAll() {
        return this.grupoDao.findAll();
    }

    @Override
    public GrupoDto findById(Long id) {
        Grupo g = this.grupoDao.findById(id).orElse(null);
        if (g != null) {
            return this.mapGrupoDto(g);
        } else {
            return new GrupoDto();
        }
    }

    @Override
    public GrupoDto save(GrupoDto grupoDto) {
        Grupo g = new Grupo();
        g.setEmpates(grupoDto.getEmpates());
        g.setGanados(grupoDto.getGanados());
        g.setGolesContra(grupoDto.getGolesContra());
        g.setGolesFavor(grupoDto.getGolesFavor());
        g.setImageGrupo(grupoDto.getImageGrupo());
        g.setJugados(grupoDto.getJugados());
        g.setPerdidos(grupoDto.getPerdidos());
        g.setPuntaje(grupoDto.getPuntaje());
        if (grupoDto.getEquipo() != null) {
            g.setEqId(grupoDto.getEquipo().getId());
        }
        g = this.grupoDao.save(g);
        return this.mapGrupoDto(g);
    }

    @Override
    public void deleteById(Long id) {
        this.grupoDao.deleteById(id);
    }

    private GrupoDto mapGrupoDto(Grupo grupo) {

        GrupoDto g = new GrupoDto();
        Equipo e = this.equipos.equipo(grupo.getEqId());
        g.setEmpates(grupo.getEmpates());
        if (e != null) {
            g.setEquipo(e);
        }
        g.setGanados(grupo.getGanados());
        g.setGolesContra(grupo.getGolesContra());
        g.setGolesFavor(grupo.getGolesFavor());
        g.setId(grupo.getId());
        g.setImageGrupo(grupo.getImageGrupo());
        g.setJugados(grupo.getJugados());
        g.setPerdidos(grupo.getPerdidos());
        g.setPuntaje(grupo.getPuntaje());

        return g;
    }
}

