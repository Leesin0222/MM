package com.example.loginandlegister

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.loginandlegister.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    //viewBinding
    private lateinit var binding: ActivityLoginBinding

    //ActionBar
    private lateinit var actionBar: ActionBar

    //progressDialog
    private lateinit var  progressDialog: ProgressDialog

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private  var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure actionbar
        actionBar = supportActionBar!!
        actionBar.hide()

        //configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("기다려주세요")
        progressDialog.setMessage("로그인중입니다")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click, open register activity
        binding.noAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        //handle click,begin login
        binding.loginBtn.setOnClickListener {
            //before logging in, validate data
            validateData()
        }

    }

    override fun onBackPressed() {
        // super.onBackPressed()
    }

    private fun validateData() {
        //get data
        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //이메일 형식에 안 맞게 썻을때
            binding.emailEt.error = "이메일 형식에 맞게 쓰세요"
        }
        else if(TextUtils.isEmpty(password)){
            //no password entered
            binding.passwordEt.error = "비밀번호를 입력해주세요"
        }
        else{
            //data is validated, begin login
            firebaseLogin()
        }
    }
    private  fun firebaseLogin() {
        //show progress
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                //login success
                progressDialog.dismiss()
                Toast.makeText(this, "환영합니다", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            .addOnFailureListener { e->
                //login failed
                progressDialog.dismiss()
                Toast.makeText(this, "정보가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                startActivity((Intent(this, LoginActivity::class.java)))
                //get user info
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email

                //open profile
                Toast.makeText(this,"loggedIn as $email", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfileActivity::class.java))
            }
    }

    private fun checkUser() {
        //만약 이미 로그인됬다면 profile로 이동
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser !=null){
            //user is already logged in
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }
}