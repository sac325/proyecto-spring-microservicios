package com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.apuestas;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.IApuestasRepository;
import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Apuestas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApuestasServiceTest {

    @Mock
    private IApuestasRepository apuestasDao;

    @InjectMocks
    private ApuestasService apuestasService;


    Apuestas apuesta = new Apuestas();
    List<Apuestas> apList = new ArrayList<>();

    @BeforeEach
    void setUp() {

        apuesta.setId(1L);
        apuesta.setGoles1(2L);
        apuesta.setGoles2(3L);
        apuesta.setFase(1L);
        apuesta.setFecha(this.obtenerFecha("12/12/2022"));
        apuesta.setGoles1(1l);
        apuesta.setGoles2(2l);
        apuesta.setResultado("E");

        apList.add(apuesta);

        apuestasService = mock(ApuestasService.class);
    }

    @Test
    void findAll() {

        when(apuestasService.findAll()).thenReturn(apList);


        List<Apuestas> p = apuestasService.findAll();


        System.out.println(p.get(0).getResultado());
        assertNotNull(p);
    }

    @Test
    void findById() {
    }


    Date obtenerFecha(String fecha){

        DateFormat fechaFormateada = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss z");
        Date fechaDevuelta = null;
        try {
            fechaDevuelta = fechaFormateada.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaDevuelta;
    }
}