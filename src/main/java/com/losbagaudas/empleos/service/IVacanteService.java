package com.losbagaudas.empleos.service;

import com.losbagaudas.empleos.model.Vacante;

import java.util.List;

public interface IVacanteService {
    List<Vacante> buscarTodas();
    Vacante buscarPorId(Integer idVacante);

    public void guardar(Vacante vacante);
}
