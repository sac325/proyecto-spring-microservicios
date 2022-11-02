package com.quiniela.app.equipos.springbootserviciogrupos.models.dto;


import com.quiniela.app.commons.models.entity.Equipo;
import com.quiniela.app.commons.models.entity.ImagenGrupos;

import lombok.Data;

import java.io.Serializable;


@SuppressWarnings("unused")
public class GrupoDto  implements Serializable {


    public GrupoDto() {
    }
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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getGanados() {
        return ganados;
    }
    public void setGanados(Long ganados) {
        this.ganados = ganados;
    }
    public Long getEmpates() {
        return empates;
    }
    public void setEmpates(Long empates) {
        this.empates = empates;
    }
    public Long getPerdidos() {
        return perdidos;
    }
    public void setPerdidos(Long perdidos) {
        this.perdidos = perdidos;
    }
    public Long getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(Long puntaje) {
        this.puntaje = puntaje;
    }
    public Long getGolesFavor() {
        return golesFavor;
    }
    public void setGolesFavor(Long golesFavor) {
        this.golesFavor = golesFavor;
    }
    public Long getGolesContra() {
        return golesContra;
    }
    public void setGolesContra(Long golesContra) {
        this.golesContra = golesContra;
    }
    public ImagenGrupos getImageGrupo() {
        return imageGrupo;
    }
    public void setImageGrupo(ImagenGrupos imageGrupo) {
        this.imageGrupo = imageGrupo;
    }
    public Long getJugados() {
        return jugados;
    }
    public void setJugados(Long jugados) {
        this.jugados = jugados;
    }
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
    
}
