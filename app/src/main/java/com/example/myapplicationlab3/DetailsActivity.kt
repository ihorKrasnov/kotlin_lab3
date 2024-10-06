package com.example.myapplicationlab3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class DetailsActivity : AppCompatActivity() {
    private val TAG = "DetailsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val json = intent.getStringExtra("USER_DATA")
        // Parse JSON string
        json?.let {
            val jsonObject = JSONObject(it)
            val name = jsonObject.getString("name")
            val surname = jsonObject.getString("surname")
            val phone = jsonObject.getString("phone")
            val email = jsonObject.getString("email")

            val nameView = findViewById<TextView>(R.id.viewTextName)
            nameView.text =
                "First name: $name"
            val surnameView = findViewById<TextView>(R.id.viewTextSurname)
            surnameView.text =
                "Last name: $surname"
            val phoneView = findViewById<TextView>(R.id.viewTextPhone)
            phoneView.text =
                "Phone number: $phone"
            val emailView = findViewById<TextView>(R.id.viewTextEmail)
            emailView.text =
                "Email: $email"
        }

        val buttonBack: Button = findViewById(R.id.buttonBack)
        buttonBack.setOnClickListener {
            //Close current activity and return on previous
            finish()
        }

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

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}