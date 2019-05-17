package br.edu.ifpb.pdm.memory_game

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import br.edu.ifpb.pdm.memory_game.controller.ListViewAdapter
import br.edu.ifpb.pdm.memory_game.dao.ProfessorDAO
import br.edu.ifpb.pdm.memory_game.model.Professor

class ListeProfessores : AppCompatActivity() {

    private lateinit var dao:ProfessorDAO
    private lateinit var lvProfessores:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_professores)

        dao = ProfessorDAO(this)
        load()
        this.lvProfessores = this.findViewById(R.id.lvProfessores)
        val listViewAdapter = ListViewAdapter(this, dao.get())
        lvProfessores.adapter = listViewAdapter
        lvProfessores.onItemClickListener = OnClickLista()
        lvProfessores.onItemLongClickListener = OnLongClickLista()


    }
    fun load(){
        dao.insert(Professor("Alana Marques de Morais", "Padrões de Projeto de Software", R.drawable.alana))
        dao.insert(Professor("Alex Sandro da Cunha Rego", "Algoritmo e Programação Estruturada", R.drawable.alex))
        dao.insert(Professor("Candido Jose Ramos do Egypto", "Algoritmo e Programação Estruturada", R.drawable.candido))
        dao.insert(Professor("Crishane Azevedo Freire", "Algoritmo e Programação Estruturada", R.drawable.crishane))
        dao.insert(Professor("Damires Yluska de Souza Fernandes", "Banco de Dados II", R.drawable.damires))
        dao.insert(Professor("Denio Mariz Timoteo de Sousa", "Segurança de Dados", R.drawable.denio))
        dao.insert(Professor("Edemberg Rocha da Silva", "Algoritmo e Programação Estruturada", R.drawable.edemberg))
        dao.insert(Professor("Fausto Veras Maranhao Ayres", "Persistência de Objetos", R.drawable.fausto))
        dao.insert(Professor("Francisco Petronio Alencar de Medeiros", "Interação Humano-Computador", R.drawable.francisco))
        dao.insert(Professor("Frederico Costa Guedes Pereira", "Fundamentos da Computação", R.drawable.fred))
        dao.insert(Professor("Giovanni Loureiro Franca de Mendonca", "Fundamentos da Computação", R.drawable.giovanni))
        dao.insert(Professor("Gustavo Wagner Diniz Mendes", "Sistemas Operacionais", R.drawable.gustavo))
        dao.insert(Professor("Heremita Brasileiro Lira", "Comércio Eletrônico - SI", R.drawable.heremita))
        dao.insert(Professor("Lafayette Batista Melo", "Métodos e Técnicas de Pesquisa SI", R.drawable.lafayette))
        dao.insert(Professor("Leonidas Francisco de Lima Junior", "Protocolos de Interconexão de Redes de Computadores", R.drawable.leonidas))
        dao.insert(Professor("Luiz Carlos Rodrigues Chaves", "Linguagens de Script", R.drawable.luiz))
        dao.insert(Professor("Nilton Freire Santos", "Banco de Dados I", R.drawable.nilton))
        dao.insert(Professor("Francisco Petronio Alencar de Medeiros", "Interação Humano-Computador", R.drawable.petronio))
        dao.insert(Professor("Pryscilla Marcili Dora", "Fundamentos de Redes de Computadores", R.drawable.pryscilla))
        dao.insert(Professor("Thiago Jose Marques Moura", "Linguagens de Marcação", R.drawable.thiago))
        dao.insert(Professor("Valeria Maria Bezerra Cavalcanti Maciel", "Programação para Dispositivos Móveis", R.drawable.valeria))
        dao.insert(Professor("Marcus Varandas", "Empreendedorismo", R.drawable.varandas))
        dao.insert(Professor("Jose Gomes Quaresma Filho", "Fundamentos de Redes de Computadores", R.drawable.zefilho))
    }
    inner class OnClickLista : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val p:Professor = lvProfessores.adapter.getItem(position) as Professor
            Toast.makeText(this@ListeProfessores, p.nome, Toast.LENGTH_SHORT).show()
        }
    }
    inner class OnLongClickLista: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
            val p:Professor = lvProfessores.adapter.getItem(position) as Professor
            Toast.makeText(this@ListeProfessores, p.disciplina, Toast.LENGTH_SHORT).show()
            return true
        }
    }
}
