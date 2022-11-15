package com.example.gaia.modelo;

import java.util.Date;

public class Cultivo {
    private int tiempoCosecha;
    private Date fechaSiembra;
    private String estado;
    private String tipo;

    public Cultivo(int tiempoCosecha, Date fechaSiembra, String estado, String tipo) {
        this.tiempoCosecha = tiempoCosecha;
        this.fechaSiembra = fechaSiembra;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Cultivo sugerirTipoCultivo(int tiempo) {

        return sugerirTipoCultivo(0);
    }


}
