package com.example.counterapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var head: TextView
    lateinit var count: TextView
    lateinit var button: Button
    lateinit var reset: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        head = findViewById(R.id.head)
        count = findViewById(R.id.count)
        button = findViewById(R.id.button)
        reset = findViewById(R.id.reset)


        val sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        var x = sharedPreferences.getInt("counter", 0)

        count.setText(x.toString())

        button.setOnClickListener(){
            x+=1
            count.setText(x.toString())

            val editor = sharedPreferences.edit()
            editor.putInt("counter", x)
            editor.apply()
        }

        reset.setOnClickListener(){
            x=0

            count.setText(x.toString())

            val editor=sharedPreferences.edit()
            editor.remove("counter")
            editor.apply()
        }


    }
}