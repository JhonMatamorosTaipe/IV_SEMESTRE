package com.matamoros.ivsemestre

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BookDatabaseHelper(context: Context)
    : SQLiteOpenHelper(context, "library.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT,
                author TEXT,
                description TEXT,
                pdfPath TEXT,
                coverPath TEXT
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS books")
        onCreate(db)
    }

    fun addBook(title: String, author: String, description: String, pdfPath: String, coverPath: String) {
        val values = ContentValues().apply {
            put("title", title)
            put("author", author)
            put("description", description)
            put("pdfPath", pdfPath)
            put("coverPath", coverPath)
        }
        writableDatabase.insert("books", null, values)
    }

    fun getAllBooks(): List<Book> {
        val books = mutableListOf<Book>()
        val cursor = readableDatabase.rawQuery("SELECT * FROM books ORDER BY id DESC", null)
        while (cursor.moveToNext()) {
            books.add(
                Book(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    title = cursor.getString(cursor.getColumnIndexOrThrow("title")),
                    author = cursor.getString(cursor.getColumnIndexOrThrow("author")),
                    description = cursor.getString(cursor.getColumnIndexOrThrow("description")),
                    pdfPath = cursor.getString(cursor.getColumnIndexOrThrow("pdfPath")),
                    coverPath = cursor.getString(cursor.getColumnIndexOrThrow("coverPath"))
                )
            )
        }
        cursor.close()
        return books
    }
}