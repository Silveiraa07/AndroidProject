package com.silveira.lista_tarefas.repository

import android.content.ContentValues
import android.content.Context
import com.silveira.lista_tarefas.model.Tarefa
import com.silveira.lista_tarefas.model.TarefaDAO

class TarefaRepository(context:Context) {
    companion object{
        private val TABLE = "tarefas"
    }
    private val db = TarefaDAO(context).writableDatabase

    fun insert(tarefa: Tarefa): Long {
        val contentValues = ContentValues().apply {
            put("tarefa",tarefa.tarefa)
        }
        return db.insert(TABLE,"",contentValues)
    }
    fun listar(): List<Tarefa> {
        return mutableListOf<Tarefa>().apply {
            val cursor = db.rawQuery("SELECT * FROM $TABLE",null)
            while (cursor.moveToNext()) {
                val id = cursor.getInt(0)
                val tarefa = cursor.getString(1)
                add(Tarefa(id,tarefa))
            }
            cursor.close()
        }
    }
}
