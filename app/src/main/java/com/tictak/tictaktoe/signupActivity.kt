package com.tictak.tictaktoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*



class signupActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        already_have_account_textview.setOnClickListener {

            Log.d("signup", "Try to show login Activity")

            //lanch login Activity

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)


        }

        register_button_register.setOnClickListener {

            performRegister()
        }
    }

    private fun performRegister(){

        val email = email_edittext_registration.text.toString()
        val password = password_edittext_registration.text.toString()

        if(email.isEmpty() || password.isEmpty()){

            Toast.makeText(this, "Please Enter text is the Fields", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("signup", "Email is: " + email)
        Log.d("signup", "password:  $password")

        //Firebase Auth
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{

            if(it.isSuccessful){
                Log.d("signup", "Successfully created user with uid: "
                        + "${it.result?.user?.uid}")

            }else{

                Log.d("signup", "create username with Email: Failure", it.exception)
                Toast.makeText(baseContext, " Authentication failed.", Toast.LENGTH_SHORT).show()

            }


        }



    }
}

