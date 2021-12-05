package com.tomuchcoffee.submissionbmaap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tomuchcoffee.submissionbmaap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCharacter: RecyclerView
    private  var characterList: ArrayList<Characters> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionBarTittle = supportActionBar
        actionBarTittle?.title = "Home"

        rvCharacter = binding.rvDemonslayer
        rvCharacter.setHasFixedSize(true)

        characterList.addAll(CharactersData.charactersData)
        setupRv()
    }

    private fun setupRv() {
        rvCharacter.layoutManager = LinearLayoutManager(this)
        val characterAdapter = CharactersAdapter(characterList)
        rvCharacter.adapter = characterAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        selectOptionItem(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    fun selectOptionItem(selecItem: Int){
        when(selecItem){
            R.id.about_me -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }





}