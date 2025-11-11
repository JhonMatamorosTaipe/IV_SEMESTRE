package com.matamoros.ivsemestre


import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.matamoros.ivsemestre.databinding.ActivityBookDetailBinding

class BookDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pdfPath = intent.getStringExtra("pdfPath")
        val title = intent.getStringExtra("title") ?: "Libro"

        supportActionBar?.title = title

        if (pdfPath != null && pdfPath.isNotEmpty()) {
            binding.webView.settings.javaScriptEnabled = true
            binding.webView.webViewClient = WebViewClient()
            binding.webView.loadUrl("file://$pdfPath")
        } else {
            binding.webView.loadData("<h3>No se encontró el PDF</h3>", "text/html", "utf-8")
        }
    }
}