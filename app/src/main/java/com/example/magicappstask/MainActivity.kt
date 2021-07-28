package com.example.magicappstask

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var saveBtn: Button
    private lateinit var myPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        saveBtn = findViewById(R.id.saveBtn)

        myPref = getSharedPreferences("preferences", MODE_PRIVATE)

        val name: String? = myPref.getString("usernameText",null)

        if (name != null){
            val intent: Intent = Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
        }

        saveBtn.setOnClickListener {
            if(username.text.isEmpty()){
                username.error = "Please enter username"
            }
            if(password.text.isEmpty()){
                password.error = "Please enter password"
            }
            val editor = myPref.edit()
            editor.putString("usernameText",username.text.toString())
            editor.putString("passwordText",password.text.toString())
            editor.apply()

            val intent: Intent = Intent(this,WelcomeActivity::class.java)
            startActivity(intent)

            Toast.makeText(this,"Login success",Toast.LENGTH_LONG).show()
        }
    }
}