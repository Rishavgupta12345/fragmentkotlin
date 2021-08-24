package com.example.fragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), Onefragment.OnMessageClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = Onefragment()

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.main_container, fragment, "OneFragment")
        fragmentTransaction.commit()

        val showFragmentMessage = findViewById<Button>(R.id.show_fragment_message)
        showFragmentMessage.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.main_container) as Onefragment
            fragment.showFragmentMessage()
        }
    }


    override fun onMessageClick() {
        showActivityMessage()
    }

    fun showActivityMessage(){
        Toast.makeText(this, "This message is from Activity", Toast.LENGTH_SHORT).show()
    }
}




