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

    lateinit var s1: TextView
    lateinit var num_s1: TextView
    lateinit var count_s1: Button
    lateinit var reset_s1: Button

    lateinit var m: TextView
    lateinit var num_m: TextView
    lateinit var count_m: Button
    lateinit var reset_m: Button

    lateinit var s2: TextView
    lateinit var num_s2: TextView
    lateinit var count_s2: Button
    lateinit var reset_s2: Button

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


        s1 = findViewById(R.id.s1)
        num_s1 = findViewById(R.id.num_s1)
        count_s1 = findViewById(R.id.count_s1)
        reset_s1 = findViewById(R.id.reset_s1)

        val sharedPreferences_s1 = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        var x1 = sharedPreferences_s1.getInt("c1", 0)

        num_s1.setText(x1.toString())

        count_s1.setOnClickListener(){
            x1+=1
            num_s1.setText(x1.toString())

            val editor = sharedPreferences_s1.edit()
            editor.putInt("c1", x1)
            editor.apply()
        }

        reset_s1.setOnClickListener(){
            x1-=1
            num_s1.setText(x1.toString())

            val editor = sharedPreferences_s1.edit()
            editor.putInt("c1", x1)
            editor.apply()
        }

        s2 = findViewById(R.id.s2)
        num_s2 = findViewById(R.id.num_s2)
        count_s2 = findViewById(R.id.count_s2)
        reset_s2 = findViewById(R.id.reset_s2)

        val sharedPreferences_s2 = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        var x2 = sharedPreferences_s2.getInt("c2", 0)

        num_s2.setText(x2.toString())

        count_s2.setOnClickListener(){
            x2+=1
            num_s2.setText(x2.toString())

            val editor = sharedPreferences_s2.edit()
            editor.putInt("c2", x2)
            editor.apply()
        }

        reset_s2.setOnClickListener(){
            x2-=1
            num_s2.setText(x2.toString())

            val editor = sharedPreferences_s2.edit()
            editor.putInt("c2", x2)
            editor.apply()
        }

        m = findViewById(R.id.m)
        num_m = findViewById(R.id.num_m)
        count_m = findViewById(R.id.count_m)
        reset_m = findViewById(R.id.reset_m)

        val sharedPreferences_m = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        var x3 = sharedPreferences_m.getInt("c3", 0)

        num_m.setText(x3.toString())

        count_m.setOnClickListener(){
            x3+=1
            num_m.setText(x3.toString())

            val editor = sharedPreferences_m.edit()
            editor.putInt("c3", x3)
            editor.apply()
        }

        reset_m.setOnClickListener(){
            x3-=1
            num_m.setText(x3.toString())

            val editor = sharedPreferences_m.edit()
            editor.putInt("c3", x3)
            editor.apply()
        }



    }
}