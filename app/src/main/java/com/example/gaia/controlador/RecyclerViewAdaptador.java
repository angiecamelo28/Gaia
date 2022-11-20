package com.example.gaia.controlador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gaia.R;
import com.example.gaia.modelo.Cultivo;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, tiempo;
        ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre =  (TextView) itemView.findViewById(R.id.txtNombreItem);
            tiempo = (TextView) itemView.findViewById(R.id.txtTiempoItem);
            imagen = (ImageView) itemView.findViewById(R.id.imagenItem);
        }
    }

    public List<Cultivo> cultivoLista;

    public RecyclerViewAdaptador(List<Cultivo>cultivoLista){

        this.cultivoLista=cultivoLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cultivo,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nombre.setText(cultivoLista.get(position).getNombre());
        //holder.tiempo.setText(cultivoLista.get(position).getTiempoCosecha());
        holder.imagen.setImageResource(cultivoLista.get(position).getImagen());
    }

    @Override
    public int getItemCount() {

        return cultivoLista.size();
    }
}










