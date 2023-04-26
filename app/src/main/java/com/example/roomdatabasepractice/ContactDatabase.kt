package com.example.roomdatabasepractice

import android.content.Context
import androidx.room.*

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Convertors::class)

abstract class ContactDatabase : RoomDatabase()
{
    abstract fun contactDAO() : ContactDAO

    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context) : ContactDatabase{
            if(INSTANCE==null)
            {
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"contactdb").build()

                }
            }
            return INSTANCE!!
        }
    }
}