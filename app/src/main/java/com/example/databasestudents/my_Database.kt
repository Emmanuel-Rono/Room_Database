package com.example.databasestudents

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Student::class], version = 1)
abstract class My_Database:RoomDatabase()
{

    //Below Code is used to create and keep "Singleton "
    //Create database is there is no exixting database




    abstract fun studentdao():StudentDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: My_Database? = null

        fun getDatabase(context: Home): My_Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    My_Database::class.java,
                    "Student_Database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}