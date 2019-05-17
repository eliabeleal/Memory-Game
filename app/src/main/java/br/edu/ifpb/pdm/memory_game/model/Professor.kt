package br.edu.ifpb.pdm.memory_game.model

import java.io.Serializable

class Professor : Serializable {
    var id: Int
    var nome: String
    var disciplina:String
    var pic: Int

    constructor(id: Int, nome: String, disciplina:String, pic: Int) {
        this.id = id
        this.nome = nome
        this.disciplina = disciplina
        this.pic = pic
    }

    constructor(nome: String, disciplina:String, pic: Int) {
        this.id = -1
        this.nome = nome
        this.disciplina = disciplina
        this.pic = pic
    }


    override fun toString(): String {
        return "$id - $nome - $disciplina - $pic"
    }
}