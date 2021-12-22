package com.example.dialogsapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R
import com.example.myapplication.Students
import com.google.android.material.textfield.TextInputEditText
import data.Db
import data.StudentsTable



class DialogAdd : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {

        // val context = this
        val context = activity
        val li = LayoutInflater.from(context)
        val view = li.inflate(R.layout.add_st_dialog, null)
        val mDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity)
        val addButton = view.findViewById<Button>(R.id.buttonInsideModal)
        val closeDialogButton = view.findViewById<Button>(R.id.closeDialogButton)
        mDialogBuilder.setView(view)

        val alertDialog = mDialogBuilder.create()

        addButton.setOnClickListener {
            val inputname = view.findViewById<TextInputEditText>(R.id.textInputEditText)
            val inputgrade = view.findViewById<TextInputEditText>(R.id.editText)
            val inputduration = view.findViewById<TextInputEditText>(R.id.editText2)
            val inputpurpose = view.findViewById<TextInputEditText>(R.id.editText3)
            val inputcost = view.findViewById<TextInputEditText>(R.id.editText4)

            val Name = inputname.text.toString()
            val Grade = inputgrade.text.toString()
            val Duration = inputduration.text.toString()
            val Purpose = inputpurpose.text.toString()
            val Cost = inputcost.text.toString()

            if (Name.isBlank() || Grade.isBlank() || Duration.isBlank() || Purpose.isBlank() || Cost.isBlank()) {
                Toast.makeText(context, "Не все поля заполнены!", Toast.LENGTH_SHORT).show()
            } else {
                val st = StudentsTable(
                    name = Name,
                    grade = Grade,
                    duration = Duration,
                    purpose = Purpose,
                    cost = Cost
                )

                this.activity?.let { it1 ->
                    Db.getDatabase(it1.applicationContext).StudentsDao().insert(st)
                }

                alertDialog.hide()
                val i = Intent(activity, Students::class.java)
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

