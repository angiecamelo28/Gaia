package com.example.gaia.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SearchView;
import com.example.gaia.R;
import com.example.gaia.db.ConexionDB;
import com.example.gaia.modelo.CultivoModelo;
import java.util.ArrayList;
import java.util.List;

public class SugerenciaCultivo extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerViewCultivo;
    private RecyclerSugerenciaCultivo adaptadorCultivo;
    ConexionDB conexion;
    SearchView txtBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencia_cultivo);

        txtBuscar = findViewById(R.id.txtBuscar);

        conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);

        recyclerViewCultivo = (RecyclerView) findViewById(R.id.listaCultivos);
        recyclerViewCultivo.setLayoutManager(new LinearLayoutManager(this));

        adaptadorCultivo = new RecyclerSugerenciaCultivo(obtenerCultivos());
        recyclerViewCultivo.setAdapter(adaptadorCultivo);

        txtBuscar.setOnQueryTextListener(this);

    }

    public List<CultivoModelo> obtenerCultivos() {
        List<CultivoModelo> listacultivos = new ArrayList<>();
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT NOMBRE,TIEMPOCOSECHA, IMAGEN FROM CULTIVO", null);
        CultivoModelo cultivo = null;

        if (cursor.moveToFirst()) {
            do {
                cultivo = new CultivoModelo(
                        cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getInt(2)

                );

                listacultivos.add(cultivo);
            } while (cursor.moveToNext());
        }
        return listacultivos;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        adaptadorCultivo.filtrar(query, this);
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


















