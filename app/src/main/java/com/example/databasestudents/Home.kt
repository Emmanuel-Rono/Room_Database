package com.example.databasestudents

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.*


class Home : Fragment() {


    lateinit var applicationContext: Context
    lateinit var data_base:My_Database
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        data_base= My_Database.getDatabase(this)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        view?.findViewById<Button>(R.id.save_Button)?.setOnClickListener {
            save_data()
        }
        val lookButton=view.findViewById<Button>(R.id.button_look)
        lookButton.setOnClickListener {
            lookupdata()
        }

        return view
    }


    private  fun lookupdata() {
        val roolno= view?.findViewById<EditText>(R.id.search_rollno)?.text.toString()
        if(roolno.isNotEmpty())
        {
            var student:Student
            GlobalScope.launch(Dispatchers.IO) {
                student = data_base.studentdao().getByRollNo(roolno.toInt())
                display(student)
            }

        }
    }

    private suspend fun display(student:Student) {
        withContext(Dispatchers.Main){
            view?.findViewById<TextView>(R.id.tvfirstname)?.text=student.FirstName
             view?.findViewById<TextView>(R.id.tvsecondname)?.text=student.SecondName

        view?.findViewById<TextView>(R.id.tvrollno)?.text=student.rollnumber


        }

    }

    private fun save_data() {
        val lastname= view?.findViewById<EditText>(R.id.etsecname)?.text.toString()
        val firstname= view?.findViewById<EditText>(R.id.etFname)?.text.toString()
        val rollno= view?.findViewById<EditText>(R.id.et_rollno)?.text.toString()

            if(lastname.isNotEmpty() && firstname.isNotEmpty() &&firstname.isNotEmpty()) {
                val student=Student(null,firstname,lastname,rollno.toInt())
                GlobalScope.launch(Dispatchers.IO){
                    data_base.studentdao().insertDetails(student)
                    //Toast.makeText(this@Home, "Data added success",Toast.LENGTH_SHORT).show()
                }
                view?.findViewById<EditText>(R.id.etsecname)?.text?.clear()
                view?.findViewById<EditText>(R.id.etFname)?.text?.clear()
                view?.findViewById<EditText>(R.id.et_rollno)?.text?.clear()

            }
        }



    }


