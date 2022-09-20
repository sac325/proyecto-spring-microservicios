package com.quiniela.app.equipos.springbootserviciopartidosapuestas.controllers.apuestas;


import com.quiniela.app.equipos.springbootserviciopartidosapuestas.models.dao.Apuestas;
import com.quiniela.app.equipos.springbootserviciopartidosapuestas.services.apuestas.IApuestasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apuestas")
public class ApuestasController {

    @Autowired
    private IApuestasService ApuestasService;

    @GetMapping("/listar")
    public List<Apuestas> listar(){
        return  ApuestasService.findAll();
    }

    @GetMapping("/listar/{id}")
    public Apuestas Apuestas(@PathVariable Long id){
        return ApuestasService.findById(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> ApuestasGuardar(@RequestBody Apuestas Apuestas){
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
