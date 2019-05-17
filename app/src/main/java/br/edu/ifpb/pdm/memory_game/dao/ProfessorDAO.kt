package br.edu.ifpb.pdm.memory_game.dao

import android.content.ContentValues
import android.content.Context
import br.edu.ifpb.pdm.memory_game.model.Professor

class ProfessorDAO {
    private var banco: BancoHelper

    constructor(context: Context) {
        this.banco = BancoHelper(context)
    }

    // create
    fun insert(p: Professor) {
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("disciplina", p.disciplina)
        cv.put("pic", p.pic)
        this.banco.writableDatabase.insert("professor", null, cv)
    }

    // all
    fun get(): List<Professor> {
        val colunas = arrayOf("id", "nome", "disciplina", "pic")
        val lista = arrayListOf<Professor>()

        val c = this.banco.readableDatabase.query("professor", colunas, null, null, null, null, "nome")

        c.moveToFirst()

        if (c.count > 0) {
            do {
                val id = c.getInt(c.getColumnIndex("id"))
                val nome = c.getString(c.getColumnIndex("nome"))
                val disciplina = c.getString(c.getColumnIndex("disciplina"))
                val pic = c.getInt(c.getColumnIndex("pic"))
                lista.add(Professor(id, nome, disciplina, pic))
            } while (c.moveToNext())
        }

        return lista
    }


    // find
    fun get(index: Int): Professor? {
        val colunas = arrayOf("id", "nome", "disciplina", "pic")
        val where = "id = ?"
        val pwhere = arrayOf(index.toString())

        val c = this.banco.readableDatabase.query("pessoa", colunas, where, pwhere, null, null, null)

        c.moveToFirst()

        if (c.count > 0) {
            val id = c.getInt(c.getColumnIndex("id"))
            val nome = c.getString(c.getColumnIndex("nome"))
            val disciplina = c.getString(c.getColumnIndex("disciplina"))
            val pic = c.getInt(c.getColumnIndex("pic"))
            return Professor(id, nome, disciplina, pic)
        }

        return null
    }

    // update
    fun update(p: Professor) {
        val where = "id = ?"
        val pwhere = arrayOf(p.id.toString())
        val cv = ContentValues()
        cv.put("nome", p.nome)
        cv.put("disciplina", p.disciplina)
        cv.put("pic", p.pic)

        this.banco.writableDatabase.update("professor", cv, where, pwhere)
    }

    // delete
    fun delete(p: Professor) {
        val where = "id = ?"
        val pwhere = arrayOf(p.id.toString())

        this.banco.writableDatabase.delete("professor", where, pwhere)
    }


}