package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySettingsBinding

class settingsActivity : AppCompatActivity() {
    lateinit var bindC :ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindC = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(bindC.root)

    }

}