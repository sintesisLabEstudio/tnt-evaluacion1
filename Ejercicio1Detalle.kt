package com.example.evaluacion1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio1Detalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1_detalle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //recibe de Ejercicio1
        val nombre = intent.getStringExtra("NOMBRE") ?: ""
        val edad = intent.getStringExtra("EDAD") ?: ""
        val area = intent.getStringExtra("AREA") ?: ""

        //componentes
        val txvNombre = findViewById<TextView>(R.id.txvNombre)
        val txvEdad = findViewById<TextView>(R.id.txvEdad)
        val txvArea = findViewById<TextView>(R.id.txvArea)

        //presenta
        txvNombre.text = "Nombre: $nombre"
        txvEdad.text = "Edad: $edad años"
        txvArea.text = "Área: $area"

        //vuelve a Ejercicio1
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
            finish()
        }

        //click vuelve a menu
        val btnMenu= findViewById<Button>(R.id.btnMenu)
        btnMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}