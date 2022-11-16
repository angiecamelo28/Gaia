package com.example.gaia.controlador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gaia.R

class DetalleCultivoFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragmento_detalle_cultivo, container, false)

        var nombre = requireArguments().getString("nombreCultivo")
        var cosecha = requireArguments().getString("cosecha")
        var imagen = requireArguments().getString("imagen")
//        var resource = R.drawable.imagen


        var textViewNombre: TextView = fragmento.findViewById(R.id.txtDetailNombre)
        var textViewcosecha: TextView = fragmento.findViewById(R.id.txtDetailTiempo)
//        var imgCultivo: ImageView = fragmento.findViewById(R.id.imgDetail)

        textViewNombre.text = nombre
        textViewcosecha.text = cosecha

//        imgCultivo.setImageResource(R.drawable.)



        return fragmento
    }

}