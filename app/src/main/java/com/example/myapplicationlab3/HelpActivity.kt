package com.example.myapplicationlab3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HelpActivity : AppCompatActivity() {
    private val TAG = "HelpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

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