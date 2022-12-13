package com.example.gaia.controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.gaia.R;
import com.example.gaia.db.ConexionDB;
import com.example.gaia.modelo.Huerta;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HuertaControlador extends AppCompatActivity {

    Spinner comboHuerta;
    ArrayList<String> listaHuertas;
    ArrayList<Huerta> huertasList;
    Button siguiente;

    public String huertaSeleccionada;


    ConexionDB conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huerta);

        //BottomAppBar bottomAppBar = (BottomAppBar) findViewById(R.id.bottomAppBar);
//        setSupportActionBar(bottomAppBar);

        //BottomNavigationItemView navigation = findViewById(R.id.bottomAppBar);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationIemSelectedListener);


        conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);

        comboHuerta = (Spinner) findViewById(R.id.comboHuerta);
        siguiente =  findViewById(R.id.btnSiguiente);

        consultarListaHuertas();

//        bottomAppBar.setNavigationOnClickListener {
//            drawerLayout.openDrawer(GravityCompat.START)
//        }
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter
                (this, android.R.layout.simple_spinner_item, listaHuertas);

        comboHuerta.setAdapter(adaptador);

        comboHuerta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                if(position>0){
                    setHuertaSeleccionada(parent.getItemAtPosition(position).toString());
                    //huertaSeleccionada=parent.getItemAtPosition(position).toString();
                    //System.out.println("------esta es la que se eligio "+huertaSeleccionada);
                }

            }

            //Método que hace parte del adaptador del RecyclerView que garantiza que la aplicación no
            //realice alguna función mientras no se tienen items seleccionados de la lista.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(), EstadoHuerta.class);
                startActivity(intento);
            }
        });

    }
/**
    private final BottomNavigationView.OnNavigationItemReselectedListener mOnNavigationIemSelectedListener = new BottomNavigationView.OnNavigationItemReselectedListener(){

        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {

        }
    }*/

    /**
     * Método para obtener los datos de la huerta almacenados en la base de datos
     */
    private void consultarListaHuertas() {
        SQLiteDatabase db = conexion.getReadableDatabase();

        Huerta huerta = null;
        huertasList = new ArrayList<Huerta>();
        Cursor cursor = db.rawQuery("SELECT * FROM HUERTA", null);
        System.out.println(cursor.moveToNext());

        if (cursor.moveToFirst()) {
            do {
                huerta = new Huerta();
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

    /**
     * Método para almacenar cada uno de los datos de la huerta en una lista
     */
    private void obtenerLista() {
        listaHuertas = new ArrayList<String>();
        listaHuertas.add("Seleccione");
        for (int i = 0; i < huertasList.size(); i++) {
            listaHuertas.add(huertasList.get(i).getId() + " - " + huertasList.get(i).getNombre());
        }
    }

    public String getHuertaSeleccionada() {
        //System.out.println("-------esta es la que debe salir "+huertaSeleccionada);
        return huertaSeleccionada;
    }

    public void setHuertaSeleccionada(String huertaSeleccionada) {
        this.huertaSeleccionada = huertaSeleccionada;
    }

/**
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.huerta:

                return true;
            case R.id.consejos:

                return true;

            case R.id.notificaciones:
                Intent intento = new Intent(getApplicationContext(), NotificacionControlador.class);
                startActivity(intento);
                return true;

            case R.id.perfil:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}