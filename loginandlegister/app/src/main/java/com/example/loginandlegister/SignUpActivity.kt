package com.example.loginandlegister

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.loginandlegister.databinding.ActivityProfileBinding
import com.example.loginandlegister.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    //ViewBinding
    private lateinit var  binding: ActivitySignupBinding

    //ActionBar
    private lateinit var  actionBar: ActionBar

    //ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    //FirebaseAuth
    private lateinit var  firebaseAuth : FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configure Actionbar
        actionBar = supportActionBar!!
        actionBar.hide()
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("기다려주세요")
        progressDialog.setMessage("계정을 생성하는 중입니다")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        //go login
        binding.gologin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        //handle click,begin signup
        binding.SignUpBtn.setOnClickListener {
            //validate Data
            validData()
        }
    }

    private fun validData() {
        //get data
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()
        //valid
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            //invalid email format
            binding.emailEt.error = "이메일 형식에 맞게 써주세요"
        }
        else if (TextUtils.isEmpty(password)) {
            //password length is less than 6
            binding.passwordEt.error = "비밀번호는 최소 6자 이상이어야합니다"
        }
        else{
            //data is va;id,continue signup
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp(){
        //show progress
        progressDialog.show()

        //create account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //signup success
                progressDialog.dismiss()
                //get current user
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "이메일로 계정이 생성되었습니다 $email", Toast.LENGTH_SHORT).show()

                //open profile
                startActivity(Intent(this,ProfileActivity::class.java))
                finish()
            }
            .addOnFailureListener {e->
                //singup failed
                progressDialog.dismiss()
                Toast.makeText(this, "이미 계정이 있습니다 ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}