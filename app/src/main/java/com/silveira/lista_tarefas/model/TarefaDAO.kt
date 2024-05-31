package com.silveira.lista_tarefas.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TarefaDAO(context:Context) : SQLiteOpenHelper(context,db_name,null,db_version) {
    companion object{
        private val db_name = "tarefas.db"
        private val db_version = 1
        private val table = "tarefas"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $table (id INTEGER PRIMARY KEY AUTOINCREMENT,tarefa TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if(oldVersion < newVersion) {
            db.execSQL("DROP TABLE $table")
            onCreate(db)
        }
    }
}