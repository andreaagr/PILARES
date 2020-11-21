package com.example.birthdaycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tarjeta2.*

class Tarjeta2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarjeta2)


        tarjeta2.setOnClickListener {
            val intent = Intent(this, Tarjeta3::class.java)
            startActivity(intent)

        }
    }
}