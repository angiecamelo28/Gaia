package com.example.gaia.controlador;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gaia.R;
import com.example.gaia.db.ConexionDB;

public class Cultivo extends AppCompatActivity {
    TextView txtNombre;
    TextView txtTipo;
    TextView txtTiempoCosecha;
    TextView txtTemperatura;
    TextView txtHumedad;
    TextView txtCiudados;

    ConexionDB conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultivo);

        conexion = new ConexionDB(getApplicationContext(), "Gaia.db", null, 1);

        txtNombre =  findViewById(R.id.txtNombre);
        txtTipo =  findViewById(R.id.txtTipo);
        txtTiempoCosecha =  findViewById(R.id.txtTiempoCosecha);
        txtTemperatura =  findViewById(R.id.txtTemperatura);
        txtHumedad =  findViewById(R.id.txtHumedad);
        txtCiudados =  findViewById(R.id.txtCiudados);

        consultarListaCultivos();

    }

    private void consultarListaCultivos() {
        SQLiteDatabase db = conexion.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT NOMBRE,TIPOCULTIVO,TIEMPOCOSECHA,TEMPERATURA,HUMEDAD," +
                "PREVENCIONCUIDADOS FROM CULTIVO WHERE ID=5", null);

        if (cursor.moveToFirst()) {
            do{
                txtNombre.setText(cursor.getString(0));
                txtTipo.setText(cursor.getString(1));
                txtTiempoCosecha.setText(cursor.getString(2));
                txtTemperatura.setText(cursor.getString(3));
                txtHumedad.setText(cursor.getString(4));
                txtCiudados.setText(cursor.getString(5));
            }while (cursor.moveToNext());
        }

    }
}
