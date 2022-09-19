package com.example.databasestudents

import androidx.room.*

@Dao
interface StudentDao
{
@Query("SELECT * FROM student_table where rollnumber LIKE :search")
suspend fun getByRollNo(search:Int):Student

@Query("SELECT * FROM student_table")
suspend fun  getAll():List<Student>//Querry to getalldata from the database
@Insert(onConflict =OnConflictStrategy.IGNORE)
fun insertDetails(student:Student) //Insert the details
    @Delete()
    suspend fun DeleteDetails(student: Student)
}