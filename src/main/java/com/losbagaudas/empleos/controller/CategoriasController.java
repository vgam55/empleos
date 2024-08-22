package com.losbagaudas.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {
    //GetMapping("/index")
    @RequestMapping  (value="/index", method= RequestMethod.GET)
    public String mostrarIndex(Model model)
    {
        String mensaje="index";
        model.addAttribute("mensaje", mensaje);
        return "categorias/listCategorias";
    }

    //GetMapping("/create")
    @RequestMapping  (value="/create", method= RequestMethod.GET)
    public String crear()
    {
        return "/categorias/formCategorias";
    }

    //GetMapping("/save")
    @RequestMapping  (value="/save", method= RequestMethod.POST)
    public String guardar(Model model, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion)
    {
        String mensaje="save";
        System.out.println("Nombre: "+nombre);
        System.out.println("Descripción: "+descripcion);
        model.addAttribute("mensaje", mensaje);
        return "categorias/listCategorias";
    }
}
