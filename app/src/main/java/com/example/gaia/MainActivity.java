package com.example.gaia;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gaia.controlador.EstadoHuerta;
import com.example.gaia.controlador.HuertaControlador;
import com.example.gaia.controlador.NotificacionControlador;
import com.example.gaia.controlador.RecyclerNotificaciones;
import com.example.gaia.db.ConexionDB;
import com.example.gaia.db.ConsultasSQL;
import com.example.gaia.servicios.Notificacion;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    private RecyclerNotificaciones adaptadorNotificacion; //---borrar
    private RecyclerView recyclerViewNotificacion;//--BORRAR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIngresar = findViewById(R.id.btnAgregar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConexionDB conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);
                conexion.getReadableDatabase();

                ConsultasSQL consultasSQL =  new ConsultasSQL();
                consultasSQL.llenarTablas(getApplicationContext());

                Intent intento = new Intent(getApplicationContext(), HuertaControlador.class);
                startActivity(intento);



            }
        });
    }


}