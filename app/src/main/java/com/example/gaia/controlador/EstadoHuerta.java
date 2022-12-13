package com.example.gaia.controlador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gaia.R;

public class EstadoHuerta extends AppCompatActivity {

    Button verInforme;
    Button sugerencia;
    TextView txtHuerta;
    HuertaControlador huertaControlador;
    String huertaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_huerta);
        sugerencia =  findViewById(R.id.btnSugerencia);
        verInforme = findViewById(R.id.btnVerInforme);
        txtHuerta = findViewById(R.id.txtHuertaSeleccionada);

        huertaControlador = new HuertaControlador();
        huertaSeleccionada=huertaControlador.getHuertaSeleccionada();
        System.out.println("-------aqui debe aparecer"+huertaControlador.getHuertaSeleccionada());
        txtHuerta.setText(huertaControlador.huertaSeleccionada);


        sugerencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(), SugerenciaCultivo.class);
                startActivity(intento);
            }
        });

        verInforme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento2 = new Intent(getApplicationContext(), InformeControlador.class);
                startActivity(intento2);
            }
        });
    }


}