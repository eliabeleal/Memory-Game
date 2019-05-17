package br.edu.ifpb.pdm.memory_game.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.edu.ifpb.pdm.memory_game.R
import br.edu.ifpb.pdm.memory_game.model.Professor


class ListViewAdapter(context: Context, private val professores: List<Professor>) : BaseAdapter() {
    private val mInflator: LayoutInflater = LayoutInflater.from(context)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.professor_row, parent, false)
            holder = ViewHolder(view)
            view.tag = holder

        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }


        val p: Professor = professores[position]
        holder.nome.text = p.nome
        holder.disciplina.text = p.disciplina
        holder.pic.setImageResource(p.pic)
        return view

    }

    override fun getItem(position: Int): Any {
        return professores.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return professores.size
    }

    inner class ViewHolder() {
        lateinit var nome: TextView
        lateinit var disciplina: TextView
        lateinit var pic: ImageView

        constructor(view: View) : this() {
            this.nome = view.findViewById(R.id.item_nome)
            this.disciplina = view.findViewById(R.id.item_disciplina)
            this.pic = view.findViewById(R.id.item_pic)
        }
    }
}