package com.rafael.firstapplication_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // val button = findViewById<Button>(R.id.button)
        // val editText = findViewById<EditText>(R.id.edit_text)
        val editText = binding.editText
        val editTextPassword = binding.editTextPassword
        val button = binding.button

        button.setOnClickListener {
            val email = editText.text.toString()
            val password = editTextPassword.text.toString()
            val message = "Email: $email\nSenha: $password"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}