package com.example.gaia.modelo;

import java.util.Date;

public class Cultivo {
    private int id;
    private String nombre;
    private int tiempoCosecha;
    private String fechaSiembra;
    private String estado;
    private String tipoCultivo;
    private String clima;
    private double temperatura;
    private int humedad;
    private String frecuenciaAbonado;
    private String frecuenciaRiego;
    private String frecuenciaFumigacion;
    private int distanciaSemillas;
    private String plagasEnfermedades;
    private String prevencionCuidados;
    private String imagenPlanta;
    private int imagen;

    public Cultivo(int tiempoCosecha, String fechaSiembra, String estado, String tipoCultivo) {
        this.tiempoCosecha = tiempoCosecha;
        this.fechaSiembra = fechaSiembra;
        this.estado = estado;
        this.tipoCultivo = tipoCultivo;
    }
    public Cultivo(){}

    public Cultivo(String nombre, int tiempoCosecha, int imagen) {
        //this.id=id;
        this.nombre = nombre;
        this.tiempoCosecha = tiempoCosecha;
        this.imagen=imagen;
        //this.imagenPlanta=imagenPlanta;
    }

    public String getImagenPlanta() {
        return imagenPlanta;
    }

    public void setImagenPlanta(String imagenPlanta) {
        this.imagenPlanta = imagenPlanta;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoCosecha() {
        return tiempoCosecha;
    }

    public void setTiempoCosecha(int tiempoCosecha) {
        this.tiempoCosecha = tiempoCosecha;
    }

    public String getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(String fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public String getFrecuenciaAbonado() {
        return frecuenciaAbonado;
    }

    public void setFrecuenciaAbonado(String frecuenciaAbonado) {
        this.frecuenciaAbonado = frecuenciaAbonado;
    }

    public String getFrecuenciaRiego() {
        return frecuenciaRiego;
    }

    public void setFrecuenciaRiego(String frecuenciaRiego) {
        this.frecuenciaRiego = frecuenciaRiego;
    }

    public String getFrecuenciaFumigacion() {
        return frecuenciaFumigacion;
    }

    public void setFrecuenciaFumigacion(String frecuenciaFumigacion) {
        this.frecuenciaFumigacion = frecuenciaFumigacion;
    }

    public int getDistanciaSemillas() {
        return distanciaSemillas;
    }

    public void setDistanciaSemillas(int distanciaSemillas) {
        this.distanciaSemillas = distanciaSemillas;
    }

    public String getPlagasEnfermedades() {
        return plagasEnfermedades;
    }

    public void setPlagasEnfermedades(String plagasEnfermedades) {
        this.plagasEnfermedades = plagasEnfermedades;
    }

    public String getPrevencionCuidados() {
        return prevencionCuidados;
    }

    public void setPrevencionCuidados(String prevencionCuidados) {
        this.prevencionCuidados = prevencionCuidados;
    }
}
