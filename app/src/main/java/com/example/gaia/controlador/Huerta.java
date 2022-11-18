package com.example.gaia.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gaia.R;
import com.example.gaia.db.ConexionDB;

import java.util.ArrayList;

public class Huerta extends AppCompatActivity {

    Spinner comboHuerta;
    ArrayList<String> listaHuertas;
    ArrayList<com.example.gaia.modelo.Huerta> huertasList;


    ConexionDB conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huerta);

        conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);

        comboHuerta = (Spinner) findViewById(R.id.comboHuerta);

        consultarListaHuertas();


        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter
                (this, android.R.layout.simple_spinner_item, listaHuertas);

        comboHuerta.setAdapter(adaptador);

        comboHuerta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    Intent intento = new Intent(getApplicationContext(), SugerenciaCultivo.class);
                    startActivity(intento);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void consultarListaHuertas() {
        SQLiteDatabase db = conexion.getReadableDatabase();

        com.example.gaia.modelo.Huerta huerta = null;
        huertasList = new ArrayList<com.example.gaia.modelo.Huerta>();
        Cursor cursor = db.rawQuery("SELECT * FROM HUERTA", null);
        System.out.println("home 59");
        System.out.println(cursor.moveToNext());

        if (cursor.moveToFirst()) {
            do {
                huerta = new com.example.gaia.modelo.Huerta();
                huerta.setId(cursor.getInt(0));
                huerta.setNombre(cursor.getString(1));
                huerta.setArea(cursor.getString(2));
                huerta.setTemperatura(cursor.getString(3));
                huerta.setHumedad(cursor.getString(4));
                huerta.setPropietario(cursor.getString(5));
                huerta.setDescripcion(cursor.getString(6));

                huertasList.add(huerta);
            } while (cursor.moveToNext());
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaHuertas = new ArrayList<String>();
        listaHuertas.add("Seleccione");
        for (int i = 0; i < huertasList.size(); i++) {
            listaHuertas.add(huertasList.get(i).getId() + " - " + huertasList.get(i).getNombre());
        }
    }

}