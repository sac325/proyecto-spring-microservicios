package com.quiniela.app.commons.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grupo")
public class Grupo  implements Serializable {

    private Long id;
    private Long ganados;
    private Long empates;
    private Long perdidos;
    private Long puntaje;
    private Long golesFavor;
    private Long golesContra;
    private ImagenGrupos imageGrupo;
    private Long jugados;
    private Long eqId;

    public Grupo() {
    }

    public Grupo(Long ganados, Long empates, Long perdidos, Long puntaje, Long golesFavor, Long golesContra, ImagenGrupos imageGrupo, Long jugados, Long eqId) {
        this.ganados = ganados;
        this.empates = empates;
        this.perdidos = perdidos;
        this.puntaje = puntaje;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.imageGrupo = imageGrupo;
        this.jugados = jugados;
        this.eqId = eqId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ganados", nullable = true)
    public Long getGanados() {
        return ganados;
    }

    public void setGanados(Long ganados) {
        this.ganados = ganados;
    }

    @Column(name = "empates", nullable = true)
    public Long getEmpates() {
        return empates;
    }

    public void setEmpates(Long empates) {
        this.empates = empates;
    }

    @Column(name = "perdidos", nullable = true)
    public Long getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(Long perdidos) {
        this.perdidos = perdidos;
    }

    @Column(name = "puntaje", nullable = true)
    public Long getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Long puntaje) {
        this.puntaje = puntaje;
    }

    @Column(name = "golesfavor", nullable = true)
    public Long getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(Long golesFavor) {
        this.golesFavor = golesFavor;
    }

    @Column(name = "golescontra", nullable = true)
    public Long getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(Long golesContra) {
        this.golesContra = golesContra;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idimagegrupo", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    public ImagenGrupos getImageGrupo() {
        return imageGrupo;
    }

    public void setImageGrupo(ImagenGrupos imageGrupo) {
        this.imageGrupo = imageGrupo;
    }

    @Column(name = "jugados", nullable = true)
    public Long getJugados() {
        return jugados;
    }

    public void setJugados(Long jugados) {
        this.jugados = jugados;
    }

  /*  @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "eq_id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    public Equipo getEqId() {
        return eqId;
    }

    public void setEqId(Equipo eqId) {
        this.eqId = eqId;
    }*/

    public Long getEqId() {
        return eqId;
    }

    public void setEqId(Long eqId) {
        this.eqId = eqId;
    }
}
