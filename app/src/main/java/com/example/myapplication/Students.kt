package com.example.myapplication

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dialogsapp.DialogAdd
import com.example.myapplication.RecyclerItemClickListener.OnItemClickListener
import data.Db


class Students : AppCompatActivity() {

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

        setTitle(R.string.ttl_students)

        setContentView(R.layout.activity_students)

        val list = findViewById<RecyclerView>(R.id.list)
        this.let {
            val l = Db.getDatabase(it.applicationContext).StudentsDao().getAll()
            list.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            list.adapter = StAdapter(l)


            //val recyclerView = findViewById<RecyclerView>(R.id.recycler)
            list.addOnItemTouchListener(
                RecyclerItemClickListener(this, list, object : OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                        Db.getDatabase(this@Students).StudentsDao().delete(l[position])

                        val i = Intent(this@Students, Students::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(i)
                    }
                })
            )

            val Button = findViewById<Button>(R.id.button9)
            Button.setOnClickListener {
                val dialog = DialogAdd()
                dialog.show(supportFragmentManager, "custom")

            }


        }
        val Buttonc = findViewById<Button>(R.id.button5)
        Buttonc.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}






