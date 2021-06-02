package com.example.foodlover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlover.entity.ItemModel
import com.example.foodlover.entity.MyAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class RecyclerviewActivity : AppCompatActivity() {

    private val db:FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference:CollectionReference = db.collection("items")

    var itemAdapter: MyAdapter? = null

    lateinit var buttonData : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val botaoCriarNovoItem : FloatingActionButton = findViewById(R.id.floatingActionButtonAdicionarItem)
        botaoCriarNovoItem.setOnClickListener {
            startActivity(Intent(this, CreateNewItemActivity::class.java))
        }

        buttonData = findViewById(R.id.atualizar)
        buttonData.setOnClickListener {
            readFirestoreData()
        }


        readFirestoreData()


    }
    fun readFirestoreData() {
        db.collection("items")
                .get()
                .addOnCompleteListener {

                    val result :StringBuffer = StringBuffer()
                    val textViewResult: TextView = findViewById(R.id.textViewResult)

                    if(it.isSuccessful) {
                        for (document in it.result!!) {
                            result.append(document.data.getValue("nome")).append(" | ")
                                    .append(document.data.getValue("avaliacao")).append(" | ")
                                    .append(document.data.getValue("descricao")).append("\n\n")
                        }
                        textViewResult.text = result
                    } else {
                        Toast.makeText(this, "deu ruim aqui irmao", Toast.LENGTH_LONG).show()
                    }
                }
    }
}