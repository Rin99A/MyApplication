package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import data.StudentsTable

class StAdapter(private val students: List<StudentsTable>) :
    RecyclerView.Adapter<StAdapter.StViewHolder>() {

    class StViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val grade: TextView
        val duration:TextView
        val purpose: TextView
        val cost: TextView

        init {
            name = itemView.findViewById(R.id.n)
            grade = itemView.findViewById(R.id.t)
            duration = itemView.findViewById(R.id.duration)
            purpose = itemView.findViewById(R.id.purpose)
            cost = itemView.findViewById(R.id.cost)
        }
    }

    var listener: AdapterView.OnItemClickListener? = null

    override fun getItemCount(): Int {
        return students.size
    }

    /*fun setData(astlist: List<String>) {
        names = astlist as List<String>
    }*/

    fun setOnClickListener(l: AdapterView.OnItemClickListener) {
        listener = l
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.st, parent, false)
        return StViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StViewHolder, position: Int) {
        holder.name.text = students[position].name
        holder.purpose.text = students[position].purpose
        holder.grade.text = students[position].grade
        holder.duration.text = students[position].duration
        holder.cost.text = students[position].cost
    }


}