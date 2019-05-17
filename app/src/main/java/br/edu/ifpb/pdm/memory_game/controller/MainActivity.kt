package br.edu.ifpb.pdm.memory_game.controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import br.edu.ifpb.pdm.memory_game.R
import br.edu.ifpb.pdm.memory_game.ListeProfessores

class MainActivity : AppCompatActivity() {

    private lateinit var btnJogar: Button
    private lateinit var btnList: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btnJogar = findViewById(R.id.btnJogar)
        btnJogar!!.setOnClickListener({play(it)})
        this.btnList = findViewById(R.id.btnListarProfessores)
        this.btnList.setOnClickListener {
            var intent = Intent(this, ListeProfessores::class.java)
            startActivity(intent)
        }


    }
    fun play(view: View){
        var intent = Intent(this, Play::class.java)
        startActivity(intent)
    }
}

