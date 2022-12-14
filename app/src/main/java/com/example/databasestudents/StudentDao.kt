package com.example.databasestudents

import android.text.Editable
import androidx.room.*

@Dao
interface StudentDao
{
@Query("SELECT * FROM student_table where rollnumber LIKE :search")
suspend fun getByRollNo(search:Int):Student

    @Insert(onConflict =OnConflictStrategy.IGNORE)
fun insertDetails(student:Student) //Insert the details
    @Delete()
    suspend fun DeleteDetails(student: Student)
}