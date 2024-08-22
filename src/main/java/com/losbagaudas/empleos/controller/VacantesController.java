package com.losbagaudas.empleos.controller;

import com.losbagaudas.empleos.model.Vacante;
import com.losbagaudas.empleos.service.VacanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private VacanteServiceImpl vacanteService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model)
    {
        List<Vacante> vacantes=vacanteService.buscarTodas();
        model.addAttribute("vacantes",vacantes);
        return "vacantes/listVacantes";
    }
    @GetMapping ("/create")
    public String crear(Vacante vacante)
    {
        return "vacantes/formVacante";
    }

   /* @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre, @RequestParam ("descripcion") String descripcion, @RequestParam("salario") double salario,
                          @RequestParam("estatus") String estatus, @RequestParam ("fecha") String fecha, @RequestParam("destacado") int destacado,
                          @RequestParam("detalles") String detalles)
    {
        System.out.println(("Nombre: "+nombre));
        return "vacantes/listVacantes";
    }*/

    @PostMapping("/save")
    public String guardar( Vacante vacante, BindingResult result)
    {
        System.out.println("Hola "+result);
      if(result.hasErrors())
        {
            for (ObjectError error: result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }

        vacanteService.guardar(vacante);
        return "redirect:/vacantes/index";
    }
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model)
    {
        Vacante vacante=null;
        vacante=vacanteService.buscarPorId(idVacante);
        System.out.println("Vacante:\n "+vacante);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model)
    {
        System.out.println("RequestParam id: "+idVacante);
        model.addAttribute("idVacante", idVacante);
        return "mensaje";
    }
}
