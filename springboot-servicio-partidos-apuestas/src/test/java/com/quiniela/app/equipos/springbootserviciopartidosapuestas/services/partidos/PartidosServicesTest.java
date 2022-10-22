package com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.partidos;

import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.IPartidosRepository;
import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Partidos;
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
import static org.mockito.Mockito.*;

class PartidosServicesTest {

    @Mock
    private IPartidosRepository partidosDao;

    @InjectMocks
    private PartidosServices partidosService;

    Partidos partido = new Partidos();
    List<Partidos> pList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        partido.setId(1L);
        partido.setEqId1(2L);
        partido.setEqId2(3L);
        partido.setFase(1L);
        partido.setFecha(this.obtenerFecha("12/12/2022"));
        partido.setGoles1(1l);
        partido.setGoles2(2l);
        partido.setHora("12:00");
        partido.setResultado("E");


        pList.add(partido);

        partidosService = mock(PartidosServices.class);
    }

    @Test
    void findAll() {


 when(partidosService.findAll()).thenReturn(pList);


 List<Partidos> p = partidosService.findAll();


        System.out.println(p.get(0).getHora());
 assertNotNull(p);


    }

    @Test
    void findById() {

        Partidos partido2 = new Partidos();
        partido2.setId(1L);
        partido2.setEqId1(2L);
        partido2.setEqId2(3L);
        partido2.setFase(1L);
        partido2.setFecha(this.obtenerFecha("12/12/2022"));
        partido2.setGoles1(1l);
        partido2.setGoles2(2l);
        partido2.setHora("12:00");
        partido2.setResultado("E");
        when(partidosService.findById(2L)).thenReturn(partido2);
        Partidos p = partidosService.findById(2L);
        System.out.println(p.getHora());
        assertNotNull(p);
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