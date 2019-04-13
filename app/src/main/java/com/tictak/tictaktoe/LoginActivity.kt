package com.tictak.tictaktoe

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        YoYo.with(Techniques.Pulse)
            .duration(700)
            .repeat(1)
            .playOn(login_button_login)

        YoYo.with(Techniques.Pulse)
            .duration(700)
            .repeat(1)
            .playOn(email_edittext_login)

        YoYo.with(Techniques.Pulse)
            .duration(700)
            .repeat(1)
            .playOn(password_edittext_login)


        not_having_account_signup.setOnClickListener {


            Log.d("MainActivity", "Try to show signup Activity")

            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }

        login_button_login.setOnClickListener {

            check_login()
        }
    }

    private fun check_login() {



        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        Log.d("login", "Attempt Login with Emial: $email, and Password: $password")

        if(email.isEmpty() || password.isEmpty()){

            Toast.makeText(this, "Enter the Credentials.", Toast.LENGTH_SHORT).show()
            return
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener{

            if(it.isSuccessful)
            {Log.d("Main", "Successfully Logged in ")
                Log.d("Main", "createUserWithEmail:success")

                val intent = Intent(this, optionActivity::class.java)
                startActivity(intent)

            }

            else{
                Log.w("Main", "createUserWithEmail:failure", it.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()

            }

        }
    }


    private fun playAnimationOnView(view: View, techniques: Techniques){
        YoYo.with(Techniques.Tada)
            .duration(700)
            .repeat(1)
            .playOn(view)
    }
}
