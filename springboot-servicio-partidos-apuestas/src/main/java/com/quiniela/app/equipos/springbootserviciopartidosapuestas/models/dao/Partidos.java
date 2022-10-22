package com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="partidos")
public class Partidos  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Long id;
    Long goles1;
    Long goles2;
    Date fecha;
    String resultado;
    @Column(name="eq_id1")
    Long eqId1;
    @Column(name="eq_id2")
    Long eqId2;
    String hora;
    Long fase;

}
