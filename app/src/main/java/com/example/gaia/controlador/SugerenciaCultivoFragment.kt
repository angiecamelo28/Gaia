package com.example.gaia.controlador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gaia.R

class SugerenciaCultivoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragmento_sugerencia_cultivo, container, false)

        val detail: ImageView = fragmento.findViewById(R.id.imgTomate)

        detail.setOnClickListener(View.OnClickListener {

            val datos = Bundle()
            datos.putString("nombreCultivo", "Tomate")
            datos.putString("cosecha","Cada 90 días")
            datos.putString("imagen","tomate")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fragment_container_view, DetalleCultivoFragment::class.java, datos, "detail")
                ?.addToBackStack("")
                ?.commit()
        })

        return fragmento
    }



}