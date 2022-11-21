package com.example.gaia.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionDB extends SQLiteOpenHelper {

    ConsultasSQL sql = new ConsultasSQL();

    public ConexionDB(Context context,String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(sql.TABLA_HUERTA);
        database.execSQL(sql.TABLA_CULTIVO);
        database.execSQL(sql.TABLA_CULTIVO_HUERTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int versionAntes, int nuevaVersion) {
        String borrarTabla = "DROP TABLE ";
        database.execSQL(borrarTabla+"HUERTA");
        database.execSQL(borrarTabla+"CULTIVO");
        database.execSQL(borrarTabla+"CULTIVO_HUERTA");
        database.execSQL(sql.TABLA_HUERTA);
        database.execSQL(sql.TABLA_CULTIVO);
        database.execSQL(sql.TABLA_CULTIVO_HUERTA);

        onCreate(database);
    }
}