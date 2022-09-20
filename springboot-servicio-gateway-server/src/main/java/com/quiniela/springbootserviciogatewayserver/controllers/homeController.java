package com.quiniela.springbootserviciogatewayserver.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class homeController {


    @GetMapping("/")
    public String listar(){
        return  "coloque la ruta.";
    }

}
