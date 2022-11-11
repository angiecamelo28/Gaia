package com.example.gaia.modelo;

import java.util.Date;

public class Cultivo {

    private int tiempoCosecha;
    private Date fechaSiembra;
    private String estado;
    private String tipo;

    public Cultivo(int tiempoCosecha, Date dechaSiembra, String estado, String tipo) {
        this.tiempoCosecha = tiempoCosecha;
        this.fechaSiembra = dechaSiembra;
        this.estado = estado;
        this.tipo = tipo;
    }

    public int getTiempoCosecha() {
        return tiempoCosecha;
    }

    public void setTiempoCosecha(int tiempoCosecha) {
        this.tiempoCosecha = tiempoCosecha;
    }

    public Date getDechaSiembra() {
        return fechaSiembra;
    }

    public void setDechaSiembra(Date dechaSiembra) {
        this.fechaSiembra = dechaSiembra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
