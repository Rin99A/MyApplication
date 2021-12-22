package com.example.myapplication

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import data.Db

open class DialogInf() :
    DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        Log.d("LOGLOGLOG", arguments.toString())
        // val context = this
        val context = activity
        val li = LayoutInflater.from(context)
        val view = li.inflate(R.layout.inf_st_dialog, null)
        val mDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity)
        mDialogBuilder.setView(view)
        val alertDialog = mDialogBuilder.create()
        val closeDialogButton = view.findViewById<Button>(R.id.closeDialogButton2)


        val Name = view.findViewById<TextView>(R.id.namest)
        val Grade = view.findViewById<TextView>(R.id.gradest)
        val Duration = view.findViewById<TextView>(R.id.durationst)
        val Purpose = view.findViewById<TextView>(R.id.purposest)
        val Cost = view.findViewById<TextView>(R.id.costst)

        this.activity?.let { it ->
            val y = Db.getDatabase(it.applicationContext).StudentsDao().getAll()

        }

        /* this.activity?.let { it1 ->
             val y = Db.getDatabase(it1.applicationContext).StudentsDao().getAll()
             //  val id =  Db.getDatabase(it1.applicationContext).StudentsDao().getid()
             Name.text = y[id].name
             Grade.text = y[id].grade
             Duration.text = y[id].duration
             Purpose.text = y[id].purpose
             Cost.text = y[id].cost
             /*   val st = StudentsTable(
         id,
         y[id].name,
         y[id].grade,
         y[id].duration,
         y[id].purpose,
         y[id].cost
     )*/
             /*   val d = view.findViewById<Button>(R.id.DeleteButton)
                d.setOnClickListener {
                    Db.getDatabase(it1.applicationContext).StudentsDao().delete(y[id])
                    alertDialog.hide()
                }*/
         }*/


        /* closeDialogButton.setOnClickListener
         {
             alertDialog.hide()
         }*/

        return alertDialog
    }
}
