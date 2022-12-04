package com.example.gaia.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.gaia.R;
import com.example.gaia.db.ConexionDB;
import com.example.gaia.modelo.Cultivo;
import com.example.gaia.controlador.RecyclerViewAdaptador;
import com.example.gaia.modelo.Huerta;

import java.util.ArrayList;
import java.util.List;

public class SugerenciaCultivo extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerViewCultivo;
    private RecyclerViewAdaptador adaptadorCultivo;
    ConexionDB conexion;
    SearchView txtBuscar;
    Spinner comboVariableCultivo;
    ArrayList<String> listaVariables;
    private String variableSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencia_cultivo);
        comboVariableCultivo = (Spinner) findViewById(R.id.comboVariable);

        txtBuscar = findViewById(R.id.txtBuscar);

        listaVariables = new ArrayList<>();
        listaVariables.add("Tiempo de cosecha");
        listaVariables.add("Temperatura");

        conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);

        recyclerViewCultivo = (RecyclerView) findViewById(R.id.listaCultivos);
        recyclerViewCultivo.setLayoutManager(new LinearLayoutManager(this));

        adaptadorCultivo = new RecyclerViewAdaptador(obtenerCultivos());
        recyclerViewCultivo.setAdapter(adaptadorCultivo);
        txtBuscar.setOnQueryTextListener(this);


        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter
                (this, android.R.layout.simple_spinner_item, listaVariables);
        comboVariableCultivo.setAdapter(adaptador);

        comboVariableCultivo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    variableSeleccionada = "tiempo";
                }else if (position == 1) {
                    variableSeleccionada = "temperatura";
                }
            }

            //Método que hace parte del adaptador del RecyclerView que garantiza que la aplicación no
            //realice alguna función mientras no se tienen items seleccionados de la lista.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public List<Cultivo> obtenerCultivos() {
        List<Cultivo> listacultivos = new ArrayList<>();
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT NOMBRE,TIEMPOCOSECHA, TEMPERATURA, IMAGEN FROM CULTIVO", null);
        Cultivo cultivo = null;

        if (cursor.moveToFirst()) {
            do {
                cultivo = new Cultivo(
                        cursor.getString(0),
                        cursor.getInt(1),
                        Double.valueOf(cursor.getString(2)),
                        cursor.getInt(3)

                );

                listacultivos.add(cultivo);
            } while (cursor.moveToNext());
        }
        return listacultivos;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if(variableSeleccionada.equals("tiempo")){
            adaptadorCultivo.filtrarTiempo(query, this);
        }else if(variableSeleccionada.equals("temperatura")){
            adaptadorCultivo.filtrarTemperatura(query, this);
        }

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()) {
            adaptadorCultivo.reiniciarLista();
        }
        return false;
    }
}


















