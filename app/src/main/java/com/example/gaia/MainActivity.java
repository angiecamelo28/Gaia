package com.example.gaia;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gaia.controlador.HuertaControlador;
import com.example.gaia.db.ConexionDB;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIngresar = findViewById(R.id.btnAgregar);
        ConexionDB conexion = new ConexionDB(MainActivity.this,"Gaia.db",null,1);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = conexion.getWritableDatabase();
                Intent intento = new Intent(getApplicationContext(), HuertaControlador.class);
                startActivity(intento);
            }
        });



    }


}