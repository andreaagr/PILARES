package com.example.birthdaycard

import android.content.Intent
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_tarjeta.*


class Tarjeta : AppCompatActivity() {
    private val constraintSetHide = ConstraintSet()
    private val constraintSetShow = ConstraintSet()
    private val transition = ChangeBounds()
    var show = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarjeta)

        //------ Guarda la referencia del lienzo sin elementos
        constraintSetHide.clone(layout_escondido)
        // ------ Guarda la referencia al lienzo con los elementos visibles
        constraintSetShow.clone(this, R.layout.activity_tarjeta_detalle)
        //------ Define la duración de la transición
        transition.duration = 1000
        //------ Cada que se presione la pantalla ...
        floatingActionButton.setOnClickListener {
            show = !show
            // ------ Indica dónde y con qué características aplicar la transición
            TransitionManager.beginDelayedTransition(layout_escondido, transition)
            if(show)
                mostrarMensaje()
            else
                ocultarMensaje()
        }

        layout_escondido.setOnClickListener {
            val intent = Intent(this, Tarjeta2::class.java)
            startActivity(intent)
        }
    }


    fun mostrarMensaje(){
        // ------ Aplica la transición
        constraintSetShow.applyTo(layout_escondido)
    }

    fun ocultarMensaje(){
        constraintSetHide.applyTo(layout_escondido)
    }
}