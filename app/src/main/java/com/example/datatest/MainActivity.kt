package com.example.datatest

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var email : TextView
    lateinit var pass : TextView
    lateinit var age : TextView
    lateinit var showDialog: Button
    lateinit var showSnackBar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        email = findViewById(R.id.email)
        pass = findViewById(R.id.password)
        age = findViewById(R.id.Age)
        showDialog = findViewById(R.id.buttonYear)
        showSnackBar = findViewById(R.id.buttonSend)

        showDialog.setOnClickListener {
            showAlertDialog()
        }




    }
    fun showAlertDialog(){

        AlertDialog.Builder(this@MainActivity)
            .setTitle("Add a year")
            .setMessage("Do you want to add a year?")
            .setCancelable(false)
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                var num = age.text.toString().toIntOrNull()
                if(num != null){
                    num = num + 1

                }
                else{
                    num = 0
                }
                age.text = num.toString()
            })
            .create().show()

    }
}