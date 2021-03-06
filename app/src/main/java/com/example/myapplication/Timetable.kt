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
import data.Db

class Timetable : AppCompatActivity() {
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
        setContentView(R.layout.activity_timetable)
        setTitle(R.string.ttl_timetable)
        /*val dialog = DialogAddL()
        dialog.show(supportFragmentManager, "custom")*/
        val Monday = findViewById<RecyclerView>(R.id.Понедельник)
        val Tuesday = findViewById<RecyclerView>(R.id.Вторник)
        val Wednesday = findViewById<RecyclerView>(R.id.Среда)
        val Thursday = findViewById<RecyclerView>(R.id.Четверг)
        val Friday = findViewById<RecyclerView>(R.id.Пятница)
        val Saturday = findViewById<RecyclerView>(R.id.Суббота)
        val Sunday = findViewById<RecyclerView>(R.id.Воскресенье)



        this.let {
            val l = Db.getDatabase(it.applicationContext).LNDao().getAll()
            // Log.d("LOGLOGLOG", l.toString())

            Monday.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            Monday.adapter = LesAdapter(l.filter { item -> item.day == "Понедельник" }.map { item ->
                Pair(item.student, item.time)
            })
            Monday.addOnItemTouchListener(
                RecyclerItemClickListener(this, Monday, object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                        Db.getDatabase(this@Timetable).LNDao().delete(l[position])

                        val i = Intent(this@Timetable, Timetable::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(i)
                    }
                })

            )
        }

        this.let {
            val l = Db.getDatabase(it.applicationContext).LNDao().getAll()
            Tuesday.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            Tuesday.adapter = LesAdapter(l.filter { item -> item.day == "Вторник" }.map { item ->
                Pair(item.student, item.time)
            })
            Tuesday.addOnItemTouchListener(
                RecyclerItemClickListener(this, Tuesday, object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                        Db.getDatabase(this@Timetable).LNDao().delete(l[position])

                        val i = Intent(this@Timetable, Timetable::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(i)
                    }
                })

            )
        }

        this.let {
            val l = Db.getDatabase(it.applicationContext).LNDao().getAll()
            Wednesday.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            Wednesday.adapter = LesAdapter(l.filter { item -> item.day == "Среда" }.map { item ->
                Pair(item.student, item.time)
            })
            Wednesday.addOnItemTouchListener(
                RecyclerItemClickListener(this, Wednesday, object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                        Db.getDatabase(this@Timetable).LNDao().delete(l[position])

                        val i = Intent(this@Timetable, Timetable::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(i)
                    }
                })

            )
        }
        this.let {
            val l = Db.getDatabase(it.applicationContext).LNDao().getAll()
            Thursday.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            Thursday.adapter = LesAdapter(l.filter { item -> item.day == "Четверг" }.map { item ->
                Pair(item.student, item.time)
            })
            Thursday.addOnItemTouchListener(
                RecyclerItemClickListener(this, Thursday, object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                        Db.getDatabase(this@Timetable).LNDao().delete(l[position])

                        val i = Intent(this@Timetable, Timetable::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(i)
                    }
                })

            )
        }

        this.let {
            val l = Db.getDatabase(it.applicationContext).LNDao().getAll()
            Friday.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            Friday.adapter = LesAdapter(l.filter { item -> item.day == "Пятница" }.map { item ->
                Pair(item.student, item.time)
            })
            Friday.addOnItemTouchListener(
                RecyclerItemClickListener(this, Friday, object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                        Db.getDatabase(this@Timetable).LNDao().delete(l[position])

                        val i = Intent(this@Timetable, Timetable::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(i)
                    }
                })

            )
        }

        this.let {
            val l = Db.getDatabase(it.applicationContext).LNDao().getAll()
            Saturday.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            Saturday.adapter = LesAdapter(l.filter { item -> item.day == "Суббота" }.map { item ->
                Pair(item.student, item.time)
            })
            Saturday.addOnItemTouchListener(
                RecyclerItemClickListener(this, Saturday, object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                        Db.getDatabase(this@Timetable).LNDao().delete(l[position])

                        val i = Intent(this@Timetable, Timetable::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(i)
                    }
                })

            )
        }
        this.let {
            val l = Db.getDatabase(it.applicationContext).LNDao().getAll()
            Sunday.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            Sunday.adapter = LesAdapter(l.filter { item -> item.day == "Воскресенье" }.map { item ->
                Pair(item.student, item.time)
            })
            Sunday.addOnItemTouchListener(
                RecyclerItemClickListener(this, Sunday, object :
                    RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {

                    }

                    override fun onLongItemClick(view: View?, position: Int) {

                        Db.getDatabase(this@Timetable).LNDao().delete(l[position])

                        val i = Intent(this@Timetable, Timetable::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(i)
                    }
                })

            )
        }
        val Button = findViewById<Button>(R.id.button6)
        Button.setOnClickListener {
            val dialog = DialogAddL()
            dialog.show(supportFragmentManager, "custom")

        }

        val Buttonc = findViewById<Button>(R.id.button7)
        Buttonc.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}