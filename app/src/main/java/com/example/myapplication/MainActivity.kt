package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var  bindC:ActivityMainBinding
    private var adapter=FilmAdapter()
    private var addLaunc:ActivityResultLauncher<Intent>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindC= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindC.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        addLaunc = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode== RESULT_OK ){
                adapter.addFilm(it.data?.getSerializableExtra("film")as Film)
            }
        }
        bindC.rcView.layoutManager =GridLayoutManager(this,2)
        bindC.rcView.adapter = adapter
        clicksListeners()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
           // R.id.menuSettings -> startActivitySetting()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu)
        return true
    }



    private fun clicksListeners(){
        bindC.bAdd.setOnClickListener {
            addLaunc?.launch(Intent(this,MainActivity2::class.java))
        }

    }
}