package com.example.unittestingsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var emailId: String
    private lateinit var passwordString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.editTextEmail)
        password = findViewById(R.id.editTextPassword)

        btnLogin.setOnClickListener {
            //createLogin()
            //tvChangedText.text = email.text.toString()
            val intent = Intent(this, SecondaryActivity::class.java)
            startActivity(intent)
        }


    }

    fun createLogin() {
        emailId = email.text.toString()
        passwordString = password.text.toString()

        val sum = doAddition(20, 30)
        Log.i("Addition", "Addition is:$sum")

        emailId = email.text.toString()
        passwordString = password.text.toString()

        Log.i("Main activity", emailId)
        Log.i("Main activity", passwordString)

        val validated = loginValidations(emailId, passwordString)
        if (validated) {
            showToast("Success")
        }
    }

    fun doAddition(first: Int, second: Int): Int {
        return first + second
    }

    fun loginValidations(email: String, pass: String): Boolean {
        if (email == "") {
            showToast("Please enter Email id")
            return false
        } else if (pass == "") {
            showToast("Please enter Password")
            return false
        } else if (!isEmailValid(email)) {
            showToast("Enter valid Email id")
            return false
        }

        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    private fun showToast(Msg_string: String) {
        val toast: Toast =
            Toast.makeText(this@MainActivity, Msg_string, Toast.LENGTH_SHORT)
        toast.show()
    }
}
