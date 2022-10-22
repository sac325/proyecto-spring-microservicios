package com.quiniela.app.equipos.springbootserviciopartidosapuestas.controllers.partidos;


import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Partidos;
import com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.partidos.IPartidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/partidos")
public class PartidosController {


    @Autowired
    private IPartidosService PartidosService;

    @GetMapping("/listar")
    public List<Partidos> listar(){
        return  PartidosService.findAll();
    }

    @GetMapping("/listar/{id}")
    public Partidos partidos(@PathVariable Long id){
        return PartidosService.findById(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> partidosGuardar(@RequestBody Partidos Partidos){
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
