package com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.apuestas;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Apuestas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IApuestasRepositoryTest {


    Apuestas apuesta = new Apuestas();
    @BeforeEach
    void setUp() {


        apuesta.setId(1L);
    }

    @Test
    public void findAll(){
        Apuestas apuesta2 = new Apuestas();
        apuesta2.setId(1L);

        assertNotNull(apuesta);
        assertEquals(apuesta.getId(),1L);
    }

}