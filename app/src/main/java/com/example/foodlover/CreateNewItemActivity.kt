package com.example.foodlover

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CreateNewItemActivity : AppCompatActivity() {

    lateinit var buttonData :AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_item)

        buttonData = findViewById(R.id.button_salvar_item)
        buttonData.setOnClickListener {
            val editTextNome: EditText? = findViewById(R.id.edit_text_nome_item)
            val nome = editTextNome?.text.toString()
            val editTextAvaliacao: EditText? = findViewById(R.id.editText_avaliacao)
            val avaliacao = editTextAvaliacao?.text.toString()
            val editTextDescricao: EditText? = findViewById(R.id.editText_descricao)
            val descricao = editTextDescricao?.text.toString()

            sendingToFirebase(nome, avaliacao, descricao )

        }

    }

    fun sendingToFirebase(nome: String, avaliacao: String, descricao: String) {

        val db = Firebase.firestore
        val itemData: MutableMap<String, Any> = HashMap()
        itemData.put("nome", nome)
        itemData.put("avaliacao", avaliacao)
        itemData.put("descricao", descricao)
        //itemData["nome"] = nome
        //itemData["avaliacao"] = avaliacao
        //itemData["descricao"] = descricao
        db.collection("items")
            .add(itemData)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(this, "recorded to database", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "ocorreu algum erro", Toast.LENGTH_LONG).show()
            }
        //editTextNome?.getText()?.clear();
        //editTextAvaliacao?.getText()?.clear();
        //editTextDescricao?.getText()?.clear();
    }


}