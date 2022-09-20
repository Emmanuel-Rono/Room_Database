package com.example.databasestudents

import android.text.Editable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase

@Entity(tableName = "student_table")
data class Student(
    @ColumnInfo(name = "First_name") val FirstName: String?,
    @ColumnInfo(name = "SecondName") val SecondName: String?,
    @PrimaryKey val rollnumber: String,
    val rollno: Int
)

