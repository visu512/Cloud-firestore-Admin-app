package com.example.cloudfirestore

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cloudfirestore.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = Firebase.firestore

        binding.button.setOnClickListener {

            val user = hashMapOf(
                "name" to binding.name.text.toString(),
                "pass" to binding.pass.text.toString()
            )
            // Add a new document with a generated ID

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->

                    Toast.makeText(
                        this,
                        "Data added Successfully!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(
                        this,
                        " \"Error : ${e.localizedMessage.toString()}",
                        Toast.LENGTH_SHORT
                    ).show()

                }
        }
    }
}