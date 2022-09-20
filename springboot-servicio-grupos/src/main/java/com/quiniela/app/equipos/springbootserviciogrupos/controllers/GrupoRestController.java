package com.quiniela.app.equipos.springbootserviciogrupos.controllers;

import com.quiniela.app.commons.models.entity.Grupo;
import com.quiniela.app.equipos.springbootserviciogrupos.models.dto.GrupoDto;
import com.quiniela.app.equipos.springbootserviciogrupos.services.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoRestController {

    @Autowired
    private IGrupoService grupoService;

    @GetMapping("/listar")
    public List<Grupo> listar(){
        return  grupoService.findAll();
    }

    @GetMapping("/listar/{id}")
    public GrupoDto grupo(@PathVariable Long id){
        return  grupoService.findById(id);
    }
}
