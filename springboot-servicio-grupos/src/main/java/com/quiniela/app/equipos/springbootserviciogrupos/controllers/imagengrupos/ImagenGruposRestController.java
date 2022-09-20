package com.quiniela.app.equipos.springbootserviciogrupos.controllers.imagengrupos;

import com.quiniela.app.commons.models.entity.ImagenGrupos;
import com.quiniela.app.equipos.springbootserviciogrupos.services.imagengrupos.IImagenGruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/imagen")
public class ImagenGruposRestController {

    @Autowired
    private IImagenGruposService imagenGruposService;

    @GetMapping("/listar")
    public List<ImagenGrupos> listar(){
        return  imagenGruposService.findAll();
    }

    @GetMapping("/listar/{id}")
    public ImagenGrupos imagengrupo(@PathVariable Long id){
        return imagenGruposService.findById(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> imagenGrupoGuardar(@RequestBody ImagenGrupos imagenGrupos){
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
