package com.example.databasestudents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Home : Fragment() {


    lateinit var data_base:My_Database
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?


    {

        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_home, container, false)
        val savedata= view?.findViewById<Button>(R.id.save_Button)
        if (savedata != null) {
            savedata.setOnClickListener {
                save_data()
            }
        }

        return view
    }

    private fun save_data() {
        val lastname= view?.findViewById<EditText>(R.id.etsecname)?.text.toString()
        val firstname= view?.findViewById<EditText>(R.id.etFname)?.text.toString()
        val rollno= view?.findViewById<EditText>(R.id.et_rollno)?.text
        if (rollno != null) {
            if(lastname.isNotEmpty() && firstname.isNotEmpty() &&rollno.isNotEmpty() )
            {
                val student=Student(null,firstname,lastname,rollno)
                GlobalScope.launch(Dispatchers.IO){
                    data_base.studentdao().insertDetails(student)
                }

                }
            }
        }
    }


