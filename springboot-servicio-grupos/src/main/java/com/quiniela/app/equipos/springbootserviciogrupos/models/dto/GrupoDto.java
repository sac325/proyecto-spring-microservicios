package com.quiniela.app.equipos.springbootserviciogrupos.models.dto;


import com.quiniela.app.commons.models.entity.Equipo;
import com.quiniela.app.commons.models.entity.ImagenGrupos;

import lombok.Data;

import java.io.Serializable;

@Data
public class GrupoDto  implements Serializable {

    private Long id;
    private Long ganados;
    private Long empates;
    private Long perdidos;
    private Long puntaje;
    private Long golesFavor;
    private Long golesContra;
    private ImagenGrupos imageGrupo;
    private Long jugados;
    private Equipo equipo;
}
