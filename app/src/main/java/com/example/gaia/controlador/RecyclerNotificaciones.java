package com.example.gaia.controlador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gaia.R;
import com.example.gaia.modelo.NotificacionModelo;
import java.util.ArrayList;
import java.util.List;

public class RecyclerNotificaciones extends RecyclerView.Adapter<RecyclerNotificaciones.ViewHolder> {
    public List<NotificacionModelo> notificacionLista;
    public List<NotificacionModelo> listaOriginal;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo, fecha, descripcion;
        ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.txtTituloNotificacion);
            fecha = (TextView) itemView.findViewById(R.id.txtFechaNotificacion);
            descripcion = (TextView) itemView.findViewById(R.id.txtContenido);
            imagen = (ImageView) itemView.findViewById(R.id.imagenItemNotificacion);
        }
    }

    public RecyclerNotificaciones(List<NotificacionModelo> notificacionLista) {

        this.notificacionLista = notificacionLista;

        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(notificacionLista);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notificacion, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.titulo.setText(notificacionLista.get(position).getTitulo());
        holder.fecha.setText(notificacionLista.get(position).getFecha());
        holder.descripcion.setText(notificacionLista.get(position).getDescripcion() + "");
        holder.imagen.setImageResource(notificacionLista.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return notificacionLista.size();
    }
}
