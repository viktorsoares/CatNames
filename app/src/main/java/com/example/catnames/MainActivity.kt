package com.example.catnames

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import kotlin.system.exitProcess
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {
    lateinit var option : Spinner
    lateinit var result : TextView
    lateinit var botton : Button
    lateinit var grup : RadioGroup
    lateinit var bottonPlay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botton = findViewById(R.id.btnLista)
        grup = findViewById(R.id.grupRadios)

        botton.setOnClickListener{if (grup.checkedRadioButtonId != null){
            var radioSelecionado: RadioButton
                radioSelecionado = findViewById(grup.checkedRadioButtonId)
                Toast.makeText(applicationContext, "Nome selecionado:" + radioSelecionado.text, Toast.LENGTH_SHORT).show()}
            else{
                Toast.makeText(applicationContext, "Nenhuma opção selecionada: ", Toast.LENGTH_SHORT).show()
            }
        }

        val btnPlay = MediaPlayer.create(this, R.raw.song)
        btnPlay.start()

        val listView = findViewById<ListView>(R.id.listviewItens)
        val names = arrayOf("Flocky", "Kuro", "Biru", "Hashira")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, i, l -> Toast.makeText(this, "Item selecionado" + names[i], Toast.LENGTH_SHORT).show() }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.criar_nome -> {
                Toast.makeText(this, "Criando um nome pra gato", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.ver_nomes -> {
                Toast.makeText(this, "Flocky", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.Gatos -> {
                Toast.makeText(this, "Gatos", Toast.LENGTH_SHORT).show()
                true
            }
            else -> exitProcess(-1)

        }
    }
}