package br.edu.ifpb.pdm.memory_game.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import br.edu.ifpb.pdm.memory_game.R
import java.util.*
import kotlin.collections.ArrayList

class Play : AppCompatActivity() {
    private var drawablePos: MutableList<Int> = ArrayList()
    private var imagePos: MutableList<Int> = ArrayList()
    private lateinit var card1: ImageView
    private lateinit var card2: ImageView
    private lateinit var arrayListCards: ArrayList<ImageView>

    private var countPair: Int = 0
    //    posicao da imagem no array
    private var currentPos = -1
    private val drawable = intArrayOf(
        R.drawable.alana,
        R.drawable.alex,
        R.drawable.candido,
        R.drawable.crishane,
        R.drawable.damires,
        R.drawable.denio,
        R.drawable.edemberg,
        R.drawable.fausto,
        R.drawable.francisco,
        R.drawable.fred,
        R.drawable.giovanni,
        R.drawable.gustavo,
        R.drawable.heremita,
        R.drawable.juliana,
        R.drawable.lafayette,
        R.drawable.leonidas,
        R.drawable.luiz,
        R.drawable.nilton,
        R.drawable.paulo,
        R.drawable.petronio,
        R.drawable.pryscilla,
        R.drawable.thiago,
        R.drawable.valeria,
        R.drawable.varandas,
        R.drawable.zefilho
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        for (i in drawable.indices) drawablePos.add(i)
        drawablePos.shuffle()

        val gridView = findViewById<GridView>(R.id.gridView)
        val imageAdapter = ImageAdapter(this)
        gridView.adapter = imageAdapter

        for (i in 0..15) {
            if (i < 8)
                imagePos.add(drawablePos[i])
            else
                imagePos.add(imagePos[i - 8])
        }
        imagePos.shuffle()
//        Log.i("pos", imagePos.toString())

        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            //                Não tocou na tela
            if (currentPos < 0) {
                currentPos = position
                card1 = view as ImageView
                card1.setImageResource(drawable[imagePos[position]])
            } else {
//                    Se clicar novamente na imagem, ela será escondida
                if (currentPos == position) {
                    card1.setImageResource(R.drawable.hildden)
                } else if (imagePos[currentPos] !== imagePos[position]) {
                    card1.setImageResource(R.drawable.hildden)
                    Toast.makeText(applicationContext, "Not match", Toast.LENGTH_SHORT).show()
                } else if (imagePos[currentPos] === imagePos[position]) {
                    card2 = view as ImageView
                    card2.setImageResource(drawable[imagePos[position]])
                    countPair++
//                    Toast.makeText(applicationContext, countPair!!.toString(), Toast.LENGTH_SHORT).show()
                    Log.i("countPair", countPair.toString())
                    if (countPair == 8) {
                        Toast.makeText(applicationContext, "You win", Toast.LENGTH_SHORT).show()
                        finish()
                    }

                }
                currentPos = -1
            }
        }
    }


}
