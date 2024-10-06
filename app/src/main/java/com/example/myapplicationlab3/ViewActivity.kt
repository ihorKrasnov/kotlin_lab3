package com.example.myapplicationlab3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class ViewActivity : AppCompatActivity() {
    private val TAG = "ViewActivity"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val json = intent.getStringExtra("USER_DATA")
        // Parse JSON string
        json?.let {
            val jsonObject = JSONObject(it)
            val name = jsonObject.getString("name")

            // Use the data
            val textViewGreeting = findViewById<TextView>(R.id.textViewGreeting)
            textViewGreeting.text =
                "Hello, $name!\n" +
                        "To get details, press the button below."
        }

        val detailsButton: Button = findViewById(R.id.buttonDetail)
        detailsButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("USER_DATA", json)

            startActivity(intent)
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