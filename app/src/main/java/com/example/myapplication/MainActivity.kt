package com.example.myapplication

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import data.Db


open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    this,
                    R.color.ab
                )
            )
        )
        Db.getDatabase(this)
        setContentView(R.layout.activity_main)
        setTitle("TimeTurner")
        val Button = findViewById<Button>(R.id.button)
        Button.setText(R.string.btn_timetable)
        Button.setOnClickListener {
            val i = Intent(this, Timetable::class.java)
            startActivity(i)
        }
        val Button2 = findViewById<Button>(R.id.button3)
        Button2.setText(R.string.btn_students)
        Button2.setOnClickListener {
            val i = Intent(this, Students::class.java)
            startActivity(i)
        }
        val Button3 = findViewById<Button>(R.id.button4)
        Button3.setText(R.string.btn_settings)
        Button3.setOnClickListener {
            val i = Intent(this, Settings::class.java)
            startActivity(i)
        }
    };

}




