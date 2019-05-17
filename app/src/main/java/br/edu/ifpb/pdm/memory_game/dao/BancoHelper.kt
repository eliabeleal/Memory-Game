package br.edu.ifpb.pdm.memory_game.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(context: Context) :
    SQLiteOpenHelper(context, "banco.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table if not exists professor (" +
                "id integer primary key autoincrement, " +
                "nome text, " +
                "disciplina text, " +
                "pic integer" +
                ")"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table professor")
        this.onCreate(db)
    }
}