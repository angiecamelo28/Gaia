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
import com.example.gaia.modelo.CultivoModelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerSugerenciaCultivo extends RecyclerView.Adapter<RecyclerSugerenciaCultivo.ViewHolder> {
    public List<CultivoModelo> cultivoLista;
    public List<CultivoModelo> listaOriginal;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, tiempo, temperatura;
        ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.txtNombreItem);
            tiempo = (TextView) itemView.findViewById(R.id.txtTiempoItem);
            temperatura = (TextView) itemView.findViewById(R.id.txtTemperaturaItem);
            imagen = (ImageView) itemView.findViewById(R.id.imagenItem);
        }
    }


    public RecyclerSugerenciaCultivo(List<CultivoModelo> cultivoLista) {

        this.cultivoLista = cultivoLista;

        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(cultivoLista);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cultivo, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void filtrarTiempo(String txtBuscar, Context context) {
        cultivoLista.clear();
        cultivoLista.addAll(listaOriginal);
        int longitud = txtBuscar.length();
        int tiempoBusqueda;
        if (longitud == 0) {
            cultivoLista.clear();
            cultivoLista.addAll(listaOriginal);
        } else {
            try {
                tiempoBusqueda = Integer.valueOf(txtBuscar);
                if (tiempoBusqueda <= 0) {
                    Toast.makeText(context, "Se debe ingresar un valor mayor a cero", Toast.LENGTH_SHORT).show();
                } else {
                    List<CultivoModelo> coleccion = cultivoLista.stream()
                            .filter(i -> i.getTiempoCosecha() <= tiempoBusqueda)
                            .collect(Collectors.toList());

                    if (coleccion.isEmpty()) {
                        Toast.makeText(context, "No se encontraron coincidencias", Toast.LENGTH_SHORT).show();
                        cultivoLista.clear();
                        cultivoLista.addAll(coleccion);
                    } else {
                        cultivoLista.clear();
                        cultivoLista.addAll(coleccion);
                    }
                }

            } catch (NumberFormatException e) {
                Toast.makeText(context, "Se debe ingresar valores num??ricos ", Toast.LENGTH_SHORT).show();
                cultivoLista.clear();
                cultivoLista.addAll(listaOriginal);

            }

        }

        notifyDataSetChanged();
    }

    public void filtrarTemperatura(String txtBuscar, Context context) {
        cultivoLista.clear();
        cultivoLista.addAll(listaOriginal);
        if(txtBuscar.contains(",")){
            txtBuscar=txtBuscar.replace(",",".");
        }
        int longitud = txtBuscar.length();
        double temperaturaBusqueda;

        if (longitud == 0) {
            cultivoLista.clear();
            cultivoLista.addAll(listaOriginal);
        } else {
            try {
                temperaturaBusqueda = Double.valueOf(txtBuscar);
                if (temperaturaBusqueda <= 0) {
                    Toast.makeText(context, "Se debe ingresar un valor mayor a cero", Toast.LENGTH_SHORT).show();
                } else {
                    List<CultivoModelo> coleccion = cultivoLista.stream()
                            .filter(i -> i.getTemperatura() <= temperaturaBusqueda)
                            .collect(Collectors.toList());

                    if (coleccion.isEmpty()) {
                        Toast.makeText(context, "No se encontraron coincidencias", Toast.LENGTH_SHORT).show();
                        cultivoLista.clear();
                        cultivoLista.addAll(coleccion);
                    } else {
                        cultivoLista.clear();
                        cultivoLista.addAll(coleccion);
                    }
                }

            } catch (NumberFormatException e) {
                Toast.makeText(context, "Se debe ingresar valores num??ricos ", Toast.LENGTH_SHORT).show();
                cultivoLista.clear();
                cultivoLista.addAll(listaOriginal);
            }

        }

        notifyDataSetChanged();
    }


    public void reiniciarLista() {
        cultivoLista.clear();
        cultivoLista.addAll(listaOriginal);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nombre.setText(cultivoLista.get(position).getNombre());
        holder.tiempo.setText(cultivoLista.get(position).getTiempoCosecha() + "");
        holder.temperatura.setText(cultivoLista.get(position).getTemperatura() + "");
        holder.imagen.setImageResource(cultivoLista.get(position).getImagen());
    }

    @Override
    public int getItemCount() {

        return cultivoLista.size();
    }
}










