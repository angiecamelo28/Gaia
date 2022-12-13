package com.example.gaia.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gaia.R;
import com.example.gaia.db.ConexionDB;
import com.example.gaia.db.ConsultasSQL;
import com.example.gaia.modelo.NotificacionModelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NotificacionControlador extends AppCompatActivity{

    private RecyclerView recyclerViewNotificacion;
    private RecyclerNotificaciones adaptadorNotificacion;
    ConexionDB conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);

        recyclerViewNotificacion = (RecyclerView) findViewById(R.id.listaNotificaciones);
        recyclerViewNotificacion.setLayoutManager(new LinearLayoutManager(this));

        adaptadorNotificacion = new RecyclerNotificaciones(obtenerNotificaciones());
        recyclerViewNotificacion.setAdapter(adaptadorNotificacion);


    }

    /**
     * Método para almacenar en una lista, uno a uno los datos de las notificaciones
     * almacenados en la base de datos
     * @return la lista con las notificaciones
     */
    public List<NotificacionModelo> obtenerNotificaciones() {
        List<NotificacionModelo> listaNotificaciones = new ArrayList<>();
        conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT TITULO,FECHA, CONTENIDO FROM HISTORIAL_NOTIFICACIONES", null);
        NotificacionModelo notificacion = null;
        if (cursor.moveToFirst()) {

            System.out.println("notificaciones 81");
            System.out.println(cursor.getString(0));

            do {
                notificacion = new NotificacionModelo(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );

                listaNotificaciones.add(notificacion);
            } while (cursor.moveToNext());
        }
        return listaNotificaciones;
    }


}