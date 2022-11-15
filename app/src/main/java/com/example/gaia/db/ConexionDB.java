package com.example.gaia.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionDB extends SQLiteOpenHelper {

    private static final String TABLA_HUERTA = "HUERTA";
    private static final String DB_NOMBRE = "GaiaDB.db";
    private static final int DB_VERSION = 1;

    public ConexionDB(Context context) {
        super(context, DB_NOMBRE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE " +TABLA_HUERTA+ "("+
                "ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "NOMBRE TEXT NOT NULL,"+
                "AREA INTEGER NOT NULL,"+
                "TEMPERATURA INTEGER NOT NULL,"+
                "HUMEDAD INTEGER NOT NULL," +
                "FECHAULTIMOABONO TEXT NOT NULL,"+
                "PROPIETARIO TEXT NOT NULL,"+
                "DESCRIPCION TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int versionAntes, int nuevaVersion) {
        database.execSQL("DROP TABLE "+TABLA_HUERTA);
        onCreate(database);
    }
}
