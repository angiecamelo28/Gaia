package com.example.gaia.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gaia.R;
import com.example.gaia.controlador.Cultivo;

public class EstadoHuerta extends AppCompatActivity {


    Button sugerencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_huerta);
        sugerencia =  findViewById(R.id.btnSugerencia);

        sugerencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(), Cultivo.class);
                startActivity(intento);
            }
        });
    }


}