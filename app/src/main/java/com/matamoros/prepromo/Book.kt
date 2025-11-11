package com.matamoros.prepromo

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val description: String,
    val pdfPath: String,
    val coverPath: String
)