package com.example.gaia.modelo;

import java.util.Date;

public class Informe {

    private String descripcion;
    private String sugerencias;
    private Date fecha;

    public Informe(String descripcion, String sugerencias, Date fecha) {
        this.descripcion = descripcion;
        this.sugerencias = sugerencias;
        this.fecha = fecha;
    }


}
