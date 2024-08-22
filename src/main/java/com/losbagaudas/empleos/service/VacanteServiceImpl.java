package com.losbagaudas.empleos.service;

import com.losbagaudas.empleos.model.Vacante;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacanteServiceImpl implements IVacanteService{

    private LinkedList<Vacante> listaVacantes;
    public VacanteServiceImpl()
    {
        listaVacantes= new LinkedList<Vacante>();
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
        vacante2.setNombre("Programador Multiplataforma");
        vacante2.setDescripcion("abcdefg");
        vacante2.setFecha(new Date());
        vacante2.setSueldo(101);
        vacante2.setDestacado(1);
        vacante2.setImagen("unicornio.png");
        listaVacantes.add(vacante2);

        //Creamos una vacante
        Vacante vacante3= new Vacante();
        vacante3.setId(3);
        vacante3.setNombre("Supercampeón");
        vacante3.setDescripcion("xyz");
        vacante3.setFecha(new Date());
        vacante3.setSueldo(102);
        vacante3.setDestacado(1);
        vacante3.setImagen("unicornio.png");
        listaVacantes.add(vacante3);
    }
    @Override
    public List<Vacante> buscarTodas() {
        return listaVacantes;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante)
    {
        for (Vacante v: listaVacantes)
        {
            if (v.getId()==idVacante)
            {
                return v;
            }
        }
        return null;
    }
    public void guardar (Vacante vacante)
    {
        listaVacantes.add(vacante);
    }
}
