package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editName = findViewById<EditText>(R.id.name)
        val editEmail = findViewById<EditText>(R.id.email)
        val editAge = findViewById<EditText>(R.id.age)

        readBtn.setOnClickListener {
            readFirebase()
        }

        writeBtn.setOnClickListener {
            var name: String
            var email: String
            var age: Int

            if (editName.length() == 0) name = "null" else name = editName.text.toString()
            if (editEmail.length() == 0) email = "null" else email = editEmail.text.toString()
            if (editAge.length() == 0) age = 0 else age = editAge.text.toString().toInt()

            writeFirebase(name, email, age)
        }
    }

    fun readFirebase(){
        db.collection("users")
            .get()
            .addOnSuccessListener {
                result -> for (document in result)
                    output1.append("${document.data} \n")
            }
            .addOnFailureListener{
                output1.append("Faliure \n")
            }
    }

    fun writeFirebase(name : String, email :String, age : Int){
        val user = mapOf(
            "name" to name,
            "email" to email,
            "age" to age
        )
        val colRef : CollectionReference = db.collection("users")
        val docRef : Task<DocumentReference> = colRef.add(user)
        docRef.addOnSuccessListener {
            documentReference -> output1.append("Success : " + "${documentReference.id} \n")
        }
        docRef.addOnFailureListener{
            output1.append("Failure \n")
        }
    }
}