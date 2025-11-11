package com.matamoros.prepromo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class VerUsuariosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_usuarios)

        val listView = findViewById<ListView>(R.id.listViewUsuarios)
        val dbHelper = DBHelper(this)
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT nombre, correo FROM usuarios", null)

        val lista = mutableListOf<String>()
        while (cursor.moveToNext()) {
            val nombre = cursor.getString(0)
            val correo = cursor.getString(1)
            lista.add("$nombre - $correo")
        }
        cursor.close()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        listView.adapter = adapter
    }
}
