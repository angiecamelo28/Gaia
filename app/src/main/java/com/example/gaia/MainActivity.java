package com.example.gaia;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gaia.controlador.ContenedorFragment;
import com.example.gaia.db.ConexionDB;

public class MainActivity extends AppCompatActivity {

    Button btnCrear;
    Button btnSugerencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear = findViewById(R.id.btnCrear);
        btnSugerencia = findViewById(R.id.btnSugerencia);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConexionDB conexion = new ConexionDB(MainActivity.this);
                SQLiteDatabase db = conexion.getWritableDatabase();
                if (db != null) {
                    // Hacer las operaciones que queramos sobre la base de datos
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnSugerencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(getApplicationContext(), ContenedorFragment.class);
                startActivity(intento);
            }
        });



    }
}