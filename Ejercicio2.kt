package com.example.evaluacion1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //componente Input sueldo
        val txtSueldo = findViewById<EditText>(R.id.txtSueldo)

        //componentes view output
        val txvSalud = findViewById<TextView>(R.id.txvSalud)
        val txvAFP = findViewById<TextView>(R.id.txtAFP)
        val txvSueldo = findViewById<TextView>(R.id.txvSueldo)
        // agregado
        val txvTotal = findViewById<TextView>(R.id.txvTotal)

        //componentes botones
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnVolver= findViewById<Button>(R.id.btnVolver)

        //vuelve a menu
        btnVolver.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //btn calculo
        btnCalcular.setOnClickListener {
            //valores enteros no vacío.
            val sueldoTexto = txtSueldo.text.toString().trim()
            val sueldoMensual = sueldoTexto.toIntOrNull()

            if (sueldoMensual == null) {
                //valida nume valido.
                val mensaje="Debe ingresar un sueldo válido (entero)"
                Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()
            } else {
                //calculo mensual
                val saludMensual = sueldoMensual * 0.10 //salud: 10%
                val afpMensual = sueldoMensual * 0.07   //afp: 7%
                val sueldoNetoMensual = sueldoMensual - (saludMensual + afpMensual)

                //calculo anual
                val saludAnual = saludMensual * 12
                val afpAnual = afpMensual * 12
                val sueldoNetoAnual = sueldoNetoMensual * 12
                val totalImpuestosAnual = afpAnual + saludAnual

                //presenta anual cn 2 decimales
                txvSalud.text = "Total Salud pagado en el año: $" + String.format("%.2f", saludAnual)
                txvAFP.text = "Total AFP pagado en el año: $" + String.format("%.2f", afpAnual)
                txvSueldo.text = "Sueldo Neto anual: $" + String.format("%.2f", sueldoNetoAnual)
                txvTotal.text = "Total impuestos anuales (AFP + Salud): $" + String.format("%.2f", totalImpuestosAnual)
            }
        }
    }
}