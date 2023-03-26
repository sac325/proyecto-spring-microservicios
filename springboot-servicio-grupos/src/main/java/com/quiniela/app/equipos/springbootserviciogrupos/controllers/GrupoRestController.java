package com.quiniela.app.equipos.springbootserviciogrupos.controllers;

import com.quiniela.app.commons.models.entity.Grupo;
import com.quiniela.app.equipos.springbootserviciogrupos.models.dto.GrupoDto;
import com.quiniela.app.equipos.springbootserviciogrupos.services.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GrupoRestController {

    @Autowired
    private IGrupoService grupoService;

    @GetMapping("/listar")
    public List<Grupo> listar() {
        return grupoService.findAll();
    }

    @GetMapping("/listar/{id}")
    public GrupoDto grupo(@PathVariable Long id) {
        return grupoService.findById(id);
    }

    @PostMapping("/crear")
    public GrupoDto crear(@RequestBody GrupoDto grupoDto) {
        return grupoService.save(grupoDto);
    }

    @PutMapping("/actualizar/{id}")
    public GrupoDto actualizar(@RequestBody GrupoDto grupoDto, @PathVariable Long id) {
        GrupoDto g = grupoService.findById(id);
        if (g.getId() != null) {
            grupoDto.setId(id);
            g = grupoService.save(grupoDto);
        }
        return g;
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        grupoService.deleteById(id);
    }
}

