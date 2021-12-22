package com.example.myapplication

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText
import data.Db
import data.LN

class DialogAddL : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {


        val context = activity
        val li = LayoutInflater.from(context)
        val view = li.inflate(R.layout.add_l_dialog, null)
        val mDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val addButton = view.findViewById<Button>(R.id.addBut)
        val closeDialogButton = view.findViewById<Button>(R.id.closeDialogButton3)
        mDialogBuilder.setView(view)
        val alertDialog = mDialogBuilder.create()


        val days = arrayOf(
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота",
            "Воскресенье"
        )
        val Spinnerd: Spinner = view.findViewById<Spinner>(R.id.spinner2)
        val adapter =
            activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, days) }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Spinnerd.setAdapter(adapter);
        val Spinnern: Spinner = view.findViewById<Spinner>(R.id.spinner3)
        val adapter2 = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                Db.getDatabase(it.applicationContext).StudentsDao().getName()
            )
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        Spinnern.setAdapter(adapter2);

        val inputtime = view.findViewById<TextInputEditText>(R.id.editText5)






        addButton.setOnClickListener {
            val Day = Spinnerd.selectedItem.toString()
            val Time = inputtime.text.toString()
            val Name = Spinnern.selectedItem.toString()

            if (Day.isBlank() || Time.isBlank() || Name.isBlank()) {
                Toast.makeText(context, "Не все поля заполнены!", Toast.LENGTH_SHORT).show()
            } else {
                val les = LN(
                    day = Day,
                    time = Time,
                    student = Name,
                )
                this.activity?.let { it1 ->
                    Db.getDatabase(it1.applicationContext).JoinDao().insert(les)
                }

                alertDialog.hide()
                val i = Intent(activity, Timetable::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(i)
            }
        }


        closeDialogButton.setOnClickListener {
            alertDialog.hide();
        }
            return alertDialog
    }
}