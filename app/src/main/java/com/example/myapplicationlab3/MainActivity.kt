package com.example.myapplicationlab3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onFormSubmit()
        Log.d(TAG, "onCreate called")
        showToast("$TAG created")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
        showToast("$TAG started")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
        showToast("$TAG resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
        showToast("$TAG paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
        showToast("$TAG stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
        showToast("$TAG destroyed")
    }

    private fun onFormSubmit() {
        editTextName = findViewById(R.id.editTextName)
        editTextSurname = findViewById(R.id.editTextSurname)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPhone = findViewById(R.id.editTextPhone)
        buttonSubmit = findViewById(R.id.button1)

        buttonSubmit.setOnClickListener {
            validateInputs()
        }
    }

    private fun validateInputs() {
        val name = editTextName.text.toString()
        val surname = editTextSurname.text.toString()
        val email = editTextEmail.text.toString()
        val phone = editTextPhone.text.toString()

        when {
            name.isEmpty() -> showToast("First name required.")
            surname.isEmpty() -> showToast("Last name required.")
            email.isEmpty() -> showToast("Email required.")
            phone.isEmpty() -> showToast("Phone number required.")
            else -> {
                // All fields entered and valid

                // Start ViewActivity and pass the UserData object
                val json = """
                {
                    "name": "$name",
                    "surname": "$surname",
                    "email": "$email",
                    "phone": "$phone"
                }
                """.trimIndent()
                val intent = Intent(this, ViewActivity::class.java)
                intent.putExtra("USER_DATA", json)

                startActivity(intent)
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.help -> {
                val intent = Intent(this, HelpActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }
}