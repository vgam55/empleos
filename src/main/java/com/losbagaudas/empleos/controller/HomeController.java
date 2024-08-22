package com.losbagaudas.empleos.controller;

import com.losbagaudas.empleos.model.Vacante;
import com.losbagaudas.empleos.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IVacanteService vacanteService=null;
    @GetMapping("/")
    public String mostrarHome(Model model)
    {
        List<Vacante>lista=vacanteService.buscarTodas();
        System.out.println (lista);
        model.addAttribute("vacantes",lista);
        return "index";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model)
    {
        List<String> lista=new LinkedList<String>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Desarrollador");
        lista.add("Vendedor");
        lista.add("Arquitecto");
        model.addAttribute("empleos",lista);
        return "listado";
    }
    @GetMapping("/detalle")
    public String mostrarDetall(Model model)
    {
        Vacante vacante=new Vacante();
        vacante.setNombre("SuperCampeon");
        vacante.setDescripcion("Ser el mejor");
        vacante.setFecha(new Date());
        vacante.setSueldo(11000.00);
        model.addAttribute("vacante",vacante);
        return "detalle";
    }

    @GetMapping ("/tabla")
    public String mostraTabla(Model model)
    {
        List<Vacante>lista=vacanteService.buscarTodas();
        model.addAttribute("vacantes",lista);
        return "tabla";
    }

   /* private List<Vacante> getVacante()
    {
        LinkedList<Vacante>listaVacantes= new LinkedList<Vacante>();
        //Creamos una vacante
            Vacante vacante1= new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Programador web");
            vacante1.setDescripcion("abcdefg");
            vacante1.setFecha(new Date());
            vacante1.setSueldo(101);
            vacante1.setDestacado(0);
            vacante1.setImagen("unicornio.png");
            listaVacantes.add(vacante1);

            //Creamos una vacante
            Vacante vacante2= new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Programador web");
            vacante2.setDescripcion("abcdefg");
            vacante2.setFecha(new Date());
            vacante2.setSueldo(101);
            vacante2.setDestacado(1);
            vacante2.setImagen("unicornio.png");
            listaVacantes.add(vacante2);

            //Creamos una vacante
            Vacante vacante3= new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Programador web");
            vacante3.setDescripcion("abcdefg");
            vacante3.setFecha(new Date());
            vacante3.setSueldo(102);
            vacante3.setDestacado(1);
            vacante3.setImagen("unicornio.png");
            listaVacantes.add(vacante3);

        return listaVacantes;
    }*/
}
