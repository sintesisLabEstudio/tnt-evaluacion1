package com.example.evaluacion1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //comonentes edit text
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtArea = findViewById<EditText>(R.id.txtArea)

        //comp botns
        val btnLimpiarRegistro = findViewById<Button>(R.id.btnLimpiarRegistro)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        //click envia
        btnEnviar.setOnClickListener {
            //valores
            val nombre = txtNombre.text.toString().trim()
            val edad = txtEdad.text.toString().trim()
            val edadNum = edad.toIntOrNull()
            var area = txtArea.text.toString().trim()

            //valida no avacio
            if(nombre.isEmpty() || edadNum==null){
                val mensaje=" Debe ingresar todos los valores"
                Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //valida area vacia el area
            if(area.isEmpty()){
                area="SIN ÁREA"
            }

            //personas >= 18
            if(edadNum<18){
                val mensaje="no es posible ingresar ya que su edad no cumple los requisitos."
                Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //no puede ingresar mas de 120
            /*
            if(edadNum>=120){
                val mensaje="dificil tener 120 años o mas en esta epoca año 2026"
                Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            */

            //envio datos a detalle
            val intent= Intent(this, Ejercicio1Detalle::class.java)
            intent.putExtra("NOMBRE",nombre)
            intent.putExtra("EDAD",edad)
            intent.putExtra("AREA",area)
            startActivity(intent)
            finish()
        }

        //limpia
        btnLimpiarRegistro.setOnClickListener {
            txtNombre.text.clear()
            txtEdad.text.clear()
            txtArea.text.clear()
        }

        //vuelve a menu
        val btnMenu = findViewById<Button>(R.id.btnMenu)
        btnMenu.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}