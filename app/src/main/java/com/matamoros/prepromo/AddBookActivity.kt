package com.matamoros.prepromo


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.matamoros.prepromo.databinding.ActivityAddBookBinding

class AddBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBookBinding
    private lateinit var db: BookDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = BookDatabaseHelper(this)

        binding.btnSave.setOnClickListener {
            val title = binding.edtTitle.text.toString().trim()
            val author = binding.edtAuthor.text.toString().trim()
            val desc = binding.edtDescription.text.toString().trim()
            val pdfPath = binding.edtPdfPath.text.toString().trim()
            val coverPath = binding.edtCoverPath.text.toString().trim()

            if (title.isEmpty() || pdfPath.isEmpty()) {
                Toast.makeText(this, "Título y PDF son requeridos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            db.addBook(title, author, desc, pdfPath, coverPath)
            Toast.makeText(this, "Libro agregado correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
