package com.quiniela.app.equipos.springbootserviciogrupos.clientes;

import com.quiniela.app.commons.models.entity.Equipo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name="servicio-equipos", url = "localhost:8001")
@FeignClient(name = "servicio-equipos")
public interface EquipoClienteRest {


    @GetMapping("/listar")
    public List<Equipo> listar();

    @GetMapping("/listar/{id}")
    public Equipo equipo(@PathVariable Long id);
}
