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
    private IApuestasService apuestasService;

    @GetMapping("/listar")
    public List<Apuestas> listar() {
        return apuestasService.findAll();
    }

    @GetMapping("/listar/{id}")
    public Apuestas apuestas(@PathVariable Long id) {
        return apuestasService.findById(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Apuestas> apuestasGuardar(@RequestBody Apuestas apuestas) {
        Apuestas apuestasGuardadas = apuestasService.save(apuestas);
        return ResponseEntity.ok(apuestasGuardadas);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Apuestas> apuestasActualizar(@RequestBody Apuestas apuestas, @PathVariable Long id) {
        Apuestas a = apuestasService.findById(id);
        if (a != null) {
            apuestas.setId(id);
            Apuestas apuestasActualizadas = apuestasService.save(apuestas);
            return ResponseEntity.ok(apuestasActualizadas);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        apuestasService.deleteById(id);
    }
}

