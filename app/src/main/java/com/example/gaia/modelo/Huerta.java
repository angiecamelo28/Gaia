package com.example.gaia.modelo;

import java.util.Date;
import java.util.List;

public class Huerta {

    private int id;
    private String nombre;
    private String area;
    private String temperatura;
    private String humedad;
    private String propietario;
    private String descripcion;

    public Huerta(String nombre, String area, String propietario) {
        this.nombre = nombre;
        this.area = area;
        this.propietario = propietario;
    }

    public Huerta(){}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
