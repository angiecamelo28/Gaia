package com.example.gaia.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.gaia.R;
import com.example.gaia.db.ConexionDB;
import com.example.gaia.modelo.Cultivo;
import com.example.gaia.controlador.RecyclerViewAdaptador;

import java.util.ArrayList;
import java.util.List;

public class SugerenciaCultivo extends AppCompatActivity {

    private RecyclerView recyclerViewCultivo;
    private RecyclerViewAdaptador adaptadorCultivo;
    ConexionDB conexion;
    public List<Cultivo> cultivoLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencia_cultivo);

        conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);

        recyclerViewCultivo = (RecyclerView) findViewById(R.id.listaCultivos);
        recyclerViewCultivo.setLayoutManager(new LinearLayoutManager(this));

        //View itemsVista = (View) findViewById(R.layout.item_cultivo);

        adaptadorCultivo = new RecyclerViewAdaptador(obtenerCultivos());
        recyclerViewCultivo.setAdapter(adaptadorCultivo);

    }

    public List<Cultivo> obtenerCultivos(){
        List<Cultivo> listacultivos = new ArrayList<>();

        SQLiteDatabase db = conexion.getReadableDatabase();

        Cultivo cultivo;
        Cursor cursor = db.rawQuery("SELECT NOMBRE,TIEMPOCOSECHA,IMAGEN FROM CULTIVO", null);

        if (cursor.moveToFirst()) {
            do {
                cultivo = new Cultivo();
                cultivo.setNombre(cursor.getString(0));
                cultivo.setTiempoCosecha(cursor.getInt(1));
                cultivo.setImagen(R.drawable.ajo);

                listacultivos.add(cultivo);
            } while (cursor.moveToNext());
        }
        return listacultivos;

    }
}