package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.view.inputmethod.InputMethodManager
import android.content.Context
import com.example.aboutme.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private var myName: MyName = MyName("Alex")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        // findViewById<Button>(R.id.done_button).setOnClickListener {
        //     addNickname(it)
        // }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View)
    {
        binding.apply {
            //nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            invalidateAll()
        }

        // Hide keyboard.
        val imm = (
            getSystemService(Context.INPUT_METHOD_SERVICE) as
            InputMethodManager
        )
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
