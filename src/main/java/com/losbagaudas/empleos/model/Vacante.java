package com.losbagaudas.empleos.model;

import java.util.Date;

public class Vacante {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private double sueldo;
    private Integer destacado;
    private String imagen="no-image.png";
    private String estatus;
    private String detalles;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getDestacado() {
        return destacado;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        String vacante="Nombre: "+this.nombre+"\n"
                        +"Descripción: "+this.descripcion+"\n"
                        +"Fecha: "+this.fecha+"\n"
                        +"Sueldo: "+this.sueldo+"\n";
        return vacante;
    }
}
