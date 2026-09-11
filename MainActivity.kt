package com.example.evaluacion1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //componente btns
        val btnEj1= findViewById<Button>(R.id.btnEj1)
        val btnEj2 = findViewById<Button>(R.id.btnEj2)

        //boton a ejercicio 1
        btnEj1.setOnClickListener {
            val intent= Intent(this, Ejercicio1::class.java)
            startActivity(intent)
            finish()
        }

        //boton a ejercicio2
        btnEj2.setOnClickListener {
            startActivity(Intent(this, Ejercicio2::class.java))
            finish()
        }
    }
}