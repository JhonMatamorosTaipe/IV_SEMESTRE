package com.matamoros.ivsemestre

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_calculadora=findViewById<Button>(R.id.btn_calculadora)

        btn_calculadora.setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java )
            startActivity(intent)
        }
        // boton biblioteca
        val btn_biblioteca=findViewById<Button>(R.id.btn_biblioteca)

        btn_biblioteca.setOnClickListener {
            val intent = Intent(this, LibraryActivity::class.java )
            startActivity(intent)
        }

        //ver usuarios
        val btn_verusaurio=findViewById<Button>(R.id.btn_verusuario)

        btn_verusaurio.setOnClickListener {
            val intent = Intent(this, VerUsuariosActivity::class.java )
            startActivity(intent)
        }


        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)

        // Obtener nombre desde el Intent
        val nombreUsuario = intent.getStringExtra("nombre_usuario")
        tvBienvenida.text = "Bienvenido, $nombreUsuario 👋"
    }
}