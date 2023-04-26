package com.example.roomdatabasepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity()
{
    lateinit var database:ContactDatabase
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDatabase(this)
        //create one more variable to store database object just to check that the value of
        //database store in both objects are same or not
//        val database2=ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDAO().insertContact(Contact(0,"Abhishek","9999", Date()))

        }

    }

    fun getData(view: View) {
        database.contactDAO().getAllContact().observe(this,{
            Log.d("Check",it.toString())
        })
    }
}