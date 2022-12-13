package com.example.gaia.servicios;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.widget.Toast;

import com.example.gaia.R;
import com.example.gaia.db.ConexionDB;
import com.example.gaia.modelo.NotificacionModelo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Notificacion {

    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;
    Date c;
    SimpleDateFormat df;
    String fecha;

    /**
     * Método para enviar notificaciones al usuario y guardarlas en la base de datos
     * para tener un historico de las alertas enviadas
     * @param context el contexto de la clase actual
     * @param titulo el titulo del mensaje a enviar
     * @param mensaje el contenido del mensaje
     */
    public void crearNotificacion(Context context, String titulo, String mensaje){
        ConexionDB conexion = new ConexionDB(context.getApplicationContext(), "Gaia.db", null, 1);

        c = Calendar.getInstance().getTime();
        df = new SimpleDateFormat("dd-MMM-yyyy");
        fecha = df.format(c);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.plantanotificacion);
        builder.setSubText(fecha);
        builder.setContentTitle(titulo);
        builder.setContentText(mensaje);
        builder.setColor(Color.rgb(216,201,185));
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setDefaults(Notification.DEFAULT_VIBRATE);
        builder.setDefaults(Notification.DEFAULT_SOUND);

        long id = insertarNotificacion(titulo,mensaje,context);
        if(id>0){
            Toast.makeText(context.getApplicationContext(), "Registro gusrdado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context.getApplicationContext(), "NOOOO", Toast.LENGTH_LONG).show();
        }


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context.getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
    }

    /**
     * Método ára crear un canal de comunicación en caso de que la version del SDK del dispositivo
     * sea mas reciente
     * @param context el contexto de la clase actual
     */
    public void crearCanalNotificacion(Context context){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public long insertarNotificacion(String titulo, String mensaje, Context context){
        System.out.println("notificacion 100");


        ConexionDB conexion = new ConexionDB(context.getApplicationContext(), "Gaia.db", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        c = Calendar.getInstance().getTime();
        df = new SimpleDateFormat("dd-MMM-yyyy");
        fecha = df.format(c);
        ContentValues valores = new ContentValues();
        valores.put("FECHA",fecha);
        valores.put("TITULO",titulo);
        valores.put("CONTENIDO",mensaje);

        long id=db.insert("HISTORIAL_NOTIFICACIONES", null,valores);

        Cursor cursor = db.rawQuery("SELECT TITULO,FECHA, CONTENIDO FROM HISTORIAL_NOTIFICACIONES", null);
        NotificacionModelo notificacion = null;
        if (cursor.moveToFirst()) {
            cursor.moveToNext();
            System.out.println(cursor.getString(0));
        }


        db.close();
        return id;
    }

}
