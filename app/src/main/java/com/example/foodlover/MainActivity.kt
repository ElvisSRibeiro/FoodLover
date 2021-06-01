package com.example.foodlover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoCriarNovoItem :FloatingActionButton = findViewById(R.id.floatingActionButtonAdicionarItem)
        botaoCriarNovoItem.setOnClickListener {
            startActivity(Intent(this, CreateNewItemActivity::class.java))
        }

    }




}