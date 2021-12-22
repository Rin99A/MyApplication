package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import data.JoinDao
import data.LesDay

class LesAdapter(private val lessons: List<LesDay >) :
    RecyclerView.Adapter<LesAdapter.LesViewHolder>() {

    class LesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val n: TextView
        val t: TextView


        init {
            n = itemView.findViewById(R.id.n)
            t = itemView.findViewById(R.id.t)

        }
    }

    var listener: AdapterView.OnItemClickListener? = null

    override fun getItemCount(): Int {
        return lessons.size
    }

    /*fun setData(astlist: List<String>) {
        names = astlist as List<String>
    }*/

    fun setOnClickListener(l: AdapterView.OnItemClickListener) {
        listener = l
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.les, parent, false)
        return LesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LesViewHolder, position: Int) {
        holder.n.text = lessons[position].student
        holder.t.text = lessons[position].time

    }


}