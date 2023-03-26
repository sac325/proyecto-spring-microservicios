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
    private IPartidosService partidosService;

    @GetMapping("/listar")
    public List<Partidos> listar() {
        return partidosService.findAll();
    }

    @GetMapping("/listar/{id}")
    public Partidos partidos(@PathVariable Long id) {
        return partidosService.findById(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Partidos> partidosGuardar(@RequestBody Partidos partidos) {
        Partidos partidosGuardados = partidosService.save(partidos);
        return ResponseEntity.ok(partidosGuardados);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Partidos> partidosActualizar(@RequestBody Partidos partidos, @PathVariable Long id) {
        Partidos p = partidosService.findById(id);
        if (p != null) {
            partidos.setId(id);
            Partidos partidosActualizados = partidosService.save(partidos);
            return ResponseEntity.ok(partidosActualizados);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        partidosService.deleteById(id);
    }
}

