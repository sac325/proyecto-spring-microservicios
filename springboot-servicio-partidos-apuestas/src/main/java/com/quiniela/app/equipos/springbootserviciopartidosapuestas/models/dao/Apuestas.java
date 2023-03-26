package com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="apuesta")
public class Apuestas   implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpartido", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    Partidos idPartido;
    Long goles1;
    Long goles2;
    Date fecha;
    String resultado;
    @Column(name="usuario")
    String usuarioApostador;
    Long puntaje;
    Long fase;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
