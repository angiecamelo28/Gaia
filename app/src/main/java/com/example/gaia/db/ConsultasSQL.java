package com.example.gaia.db;

public class ConsultasSQL {

    public static final String TABLA_HUERTA =
            "CREATE TABLE HUERTA("+
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "NOMBRE TEXT NOT NULL,"+
                    "AREA INTEGER NOT NULL,"+
                    "TEMPERATURA INTEGER,"+
                    "HUMEDAD INTEGER," +
                    "FECHAULTIMOABONO TEXT,"+
                    "PROPIETARIO TEXT NOT NULL,"+
                    "DESCRIPCION TEXT)";

    public final String TABLA_CULTIVO =
            "CREATE TABLE CULTIVO("+
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "NOMBRE TEXT NOT NULL,"+
                    "TIEMPOCOSECHA INTEGER NOT NULL,"+
                    "FECHASIEMBRA TEXT NOT NULL,"+
                    "ESTADO TEXT,"+
                    "TIPOCULTIVO TEXT NOT NULL,"+
                    "CLIMA TEXT NOT NULL,"+
                    "TEMPERATURA TEXT NOT NULL,"+
                    "HUMEDAD INTEGER NOT NULL,"+
                    "FRECUENCIAABONADO TEXT,"+
                    "FRECUENCIARIEGO TEXT,"+
                    "FRECUENCIAFUMIGACION TEXT,"+
                    "DISTANCIASEMILLAS INTEGER,"+
                    "PLAGASENFERMEDADES TEXT,"+
                    "PREVENCIONCUIDADOS TEXT)";

    public final String TABLA_CULTIVO_HUERTA=
            "CREATE TABLE CULTIVO_HUERTA("+
                    "CULTIVOID INTEGER,"+
                    "HUERTAID INTEGER,"+
                    "CONSTRAINT FK_HUERTA FOREIGN KEY(HUERTAID) REFERENCES HUERTA(ID),"+
                    "CONSTRAINT FK_CULTIVO FOREIGN KEY(CULTIVOID) REFERENCES CULTIVO(ID))";
}
