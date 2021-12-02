package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var clickCount = 0
        var map =  mutableMapOf<String,Int>()
        val userName = findViewById<TextInputLayout>(R.id.userInput)
        val btnClick = findViewById<Button>(R.id.clickBtn)
        val displayRes = findViewById<TextView>(R.id.resultText)

        btnClick.setOnClickListener{
            val name = userName.editText?.text?.toString()
            if(map.containsKey(name)){
                var v = map[name]
                if (v != null) {
                    map.put(name.toString(),v.plus(1))
                }
            }else{
                map.put(name.toString(),1)
            }
            var displayName = ""
            if(name.isNullOrEmpty()){
                clickCount ++
                displayName = "Somebody".toString()
            }else{
                clickCount = map[name]!!
                displayName = name
            }
            displayRes.text = "$displayName clicks $clickCount times"
        }


    }
}

