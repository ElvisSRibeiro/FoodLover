package com.example.foodlover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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