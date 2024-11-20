package com.example.basics

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class InteractionActivity : AppCompatActivity() {
    lateinit var btnSnack: Button
    lateinit var btnAlert: Button
    lateinit var btnToast: Button
    lateinit var main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_interaction)

        main = findViewById(R.id.main)
        btnSnack = findViewById(R.id.btnSnack)
        btnAlert = findViewById(R.id.btnAlert)
        btnToast = findViewById(R.id.btnToast)

        btnToast.setOnClickListener {
            Toast.makeText(
                this@InteractionActivity,
                "Login Success", Toast.LENGTH_LONG
            ).show()
        }

        btnSnack.setOnClickListener {
            Snackbar.make(
                main,
                "Invalid login",
                Snackbar.LENGTH_LONG
            ).setAction("Close", {})
                .show()
        }
        btnAlert.setOnClickListener {
            val alert = AlertDialog.Builder(this@InteractionActivity)
            alert.setTitle("Confirmation")
                .setMessage("Are you sure?")
                .setIcon(R.drawable.apple)
                .setNegativeButton("No",
                    DialogInterface.OnClickListener {
                                                    dialogInterface, i ->
                        dialogInterface.dismiss()
                    })
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener
                    { dialogInterface, i ->  })

            alert.create().show()


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}