package com.example.loginandlegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.loginandlegister.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    //view Binding
    private lateinit var binding: ActivityProfileBinding

    //ActionBar
    private  lateinit var actionbar: ActionBar

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure ActionBar
        actionbar = supportActionBar!!
        actionbar.title = "🖖선택의 갈림길"

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click, logout
        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
        binding.goWorld.setOnClickListener {
            startActivity(Intent(this,WorldActivity::class.java))
            finish()
        }
        binding.popularbtn.setOnClickListener {
            startActivity(Intent(this,PopularActivity::class.java))
        }

    }

    override fun onBackPressed() {
     //   super.onBackPressed()
    }

    private fun checkUser() {
        //check user is logged in or not
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            //user not null, user is logged in,get user info
            val email = firebaseUser.email
            //set to text view
            binding.emailTv.text = email
        }
        else{
            //user is null, user is not loggend in, goto login activity
            startActivity((Intent(this, LoginActivity::class.java)))
        }

    }
}