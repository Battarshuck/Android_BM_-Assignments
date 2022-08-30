package com.example.myfirstapp
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn_register = findViewById<Button>(R.id.btn_register)
        val editTextName = findViewById<EditText>(R.id.editText_name)

        btn_register.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java).apply {
                putExtra("userName", editTextName.text.toString())
            }

            startActivity(intent)
        }
    }
}