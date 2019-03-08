package com.example.networkstate

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var toast1: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonNet)
        button.setOnClickListener {
            var connection = isNetworkAvailable()
            toast1 = Toast.makeText(applicationContext, "CLICK EN BOTON $connection", Toast.LENGTH_SHORT)
            toast1.show()
        }

    }

    override fun onResume() {
        super.onResume()

    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        Log.d("INFOOOO", activeNetworkInfo.toString())
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
