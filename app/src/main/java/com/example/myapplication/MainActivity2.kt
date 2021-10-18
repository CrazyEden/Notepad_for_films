package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    lateinit var  bindC: ActivityMain2Binding
    var i= 0
    var iId =R.drawable.dominoes
    var uri:Uri?=null
    private var imageFilmIdList= listOf(
        R.drawable.avatar,
        R.drawable.titanic,
        R.drawable.spririt,
        R.drawable.dominoes
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindC= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindC.root)

        pickImage()
    }

    private fun pickImage() {
        var pickLauncer = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                uri = it
                bindC.imageView.setImageURI(it)
            })
        bindC.imageView.setOnClickListener {
            pickLauncer.launch("image/*")
        }
    }



    fun bDont(view: android.view.View) {
        val ur = uri.toString()
        var film = Film(ur, bindC.editTitle.text.toString(), bindC.editRate.text.toString(), bindC.editDiscription.text.toString())
        val eIntent = Intent().apply {
            putExtra("film",film)
        }
        setResult(RESULT_OK, eIntent)
        finish()
    }

}