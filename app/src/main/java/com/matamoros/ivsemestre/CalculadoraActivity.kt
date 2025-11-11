package com.matamoros.ivsemestre

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val n1=findViewById<EditText>(R.id.txt_n1)
        val n2=findViewById<EditText>(R.id.txt_n2)
        val r=findViewById<TextView>(R.id.txt_r)
        val btn_sumar=findViewById<Button>(R.id.btn_sumar)
        val btn_restar=findViewById<Button>(R.id.btn_restar)
        val btn_limpiar=findViewById<Button>(R.id.btn_limpiar)

        btn_sumar.setOnClickListener {
            val num1 = n1.text.toString().toIntOrNull() ?: 0
            val num2 = n2.text.toString().toIntOrNull() ?: 0
            val resultado = sumar(num1, num2)
            r.text = "La suma es: $resultado"
        }

        btn_restar.setOnClickListener {
            val num1 = n1.text.toString().toIntOrNull() ?: 0
            val num2 = n2.text.toString().toIntOrNull() ?: 0
            val resultado2 = restar(num1, num2)
            r.text = "La resta es: $resultado2"

        }
        btn_limpiar.setOnClickListener {
            n1.setText("")
            n2.setText("")

            r.text = "Resultado"
        }
    }
    private fun sumar(a: Int, b: Int): Int {
        return a + b
    }
    private fun restar(a: Int, b: Int): Int {

        return a - b
    }
}