package com.example.gaia.modelo;

import java.util.Date;
import java.util.List;

public class Huerta {

    private String nombre;
    private double area;
    private double temperatura;
    private double humedad;
    private Date fechaUltimoAbono;
    private String propietario;
    private String descripcion;
    private List cultivos;

    public Huerta(String nombre, double area, double temperatura, double humedad,
                  Date fechaUltimoAbono, String propietario, String descripcion, List cultivos) {
        this.nombre = nombre;
        this.area = area;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.fechaUltimoAbono = fechaUltimoAbono;
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.cultivos = cultivos;
    }
}
