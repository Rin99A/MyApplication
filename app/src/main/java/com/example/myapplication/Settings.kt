package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.*

class Settings : AppCompatActivity() {
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
        setContentView(R.layout.activity_settings)
        setTitle(R.string.ttl_settings)
        val textView = findViewById<TextView>(R.id.textView)
        textView.setText(R.string.language)
        val languages = arrayOf("Русский", "English")
        val Spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        fun changelocale(locale: Locale) {
            Locale.setDefault(locale)
            val configuration = Configuration()
            configuration.setLocale(locale)
            getBaseContext().getResources().updateConfiguration(
                configuration,
                getBaseContext().getResources().getDisplayMetrics()
            );
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Spinner.setAdapter(adapter);
        Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    val locale = Locale("ru")
                    changelocale(locale)
                }
                if (position == 1) {
                    val locale = Locale("en")
                    changelocale(locale)
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val Button4 = findViewById<Button>(R.id.button2)
        Button4.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }

}

