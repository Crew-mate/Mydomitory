package com.example.mydomitory

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        val signin_btn = findViewById<Button>(R.id.signin_btn)
        val email = findViewById<EditText>(R.id.email_edit)
        val pwd = findViewById<EditText>(R.id.pass_edit)

        signin_btn.setOnClickListener {
            //회원가입을 눌렀을 때 로그인이 되도록 함
            auth.createUserWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        //login 성공시
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                    } else {
                        //login 실패시
                        Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}