package com.example.gaia.controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gaia.R;
import com.example.gaia.modelo.Cultivo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public List<Cultivo> cultivoLista;
    public List<Cultivo> listaOriginal;
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



    public RecyclerViewAdaptador(List<Cultivo>cultivoLista){

        this.cultivoLista=cultivoLista;

        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(cultivoLista);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cultivo,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void filtrar(String txtBuscar, Context context){
        int longitud = txtBuscar.length();
        int tiempoBusqueda;

        if (longitud == 0){
            cultivoLista.clear();
            cultivoLista.addAll(listaOriginal);
        }else {
            try {
                tiempoBusqueda= Integer.valueOf(txtBuscar);
                List<Cultivo> coleccion = cultivoLista.stream()
                        .filter(i -> i.getTiempoCosecha() <=tiempoBusqueda)
                        .collect(Collectors.toList());

                if(coleccion.isEmpty()){
                    Toast.makeText(context, "No se encontraron coincidencias", Toast.LENGTH_SHORT).show();
                }else {
                    cultivoLista.clear();
                    cultivoLista.addAll(coleccion);
                }

            }catch (NumberFormatException e){
                cultivoLista.addAll(listaOriginal);
            }

        }

        notifyDataSetChanged();
    }

    public void reiniciarLista(){
        cultivoLista.clear();
        cultivoLista.addAll(listaOriginal);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nombre.setText(cultivoLista.get(position).getNombre());
        holder.tiempo.setText(cultivoLista.get(position).getTiempoCosecha()+"");
        holder.imagen.setImageResource(cultivoLista.get(position).getImagen());
    }

    @Override
    public int getItemCount() {

        return cultivoLista.size();
    }
}










