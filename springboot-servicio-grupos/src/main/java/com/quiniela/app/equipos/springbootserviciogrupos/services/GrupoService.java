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

 /*   @Override
    @Transactional(readOnly = true)
    public List<GrupoDto> findAll() {
        List<Grupo> g= this.grupoDao.findAll();
        System.out.println("lista de grupos: " + String.valueOf(g.size()));
        List<GrupoDto>  gDto= g.stream().map(grupo -> this.mapGrupoDto(grupo)).collect(Collectors.toList());
        System.out.println("lista de grupos: " + String.valueOf(gDto.size()));

        return gDto;
    }
*/
    @Override
    public GrupoDto findById(Long id) {
        Grupo g = this.grupoDao.findById(id).orElse(null);
        if (g != null){
           return this.mapGrupoDto(g);
        }else{
            return new GrupoDto();
        }
    }

    private GrupoDto mapGrupoDto(Grupo grupo){
      //  System.out.println("id del grupo: " + String.valueOf(grupo.getId()));
        GrupoDto g = new GrupoDto();
        Equipo e = this.equipos.equipo(grupo.getEqId());
        g.setEmpates(grupo.getEmpates());
        if (e != null)
        g.setEquipo(e);

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
