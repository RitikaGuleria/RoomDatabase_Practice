package com.example.roomdatabasepractice

import androidx.room.TypeConverter
import java.util.*

class Convertors {

    //to store in roomdb we need to convet date into long bcz date type cannot be directly store in roomdb
    @TypeConverter
    fun fromDateToLong(value: Date):Long{
        return value.time
    }

    //to feth from roomdb, so converting long type to date again
    @TypeConverter
    fun fromLongToDate(value:Long):Date{
        return Date(value)
    }
}