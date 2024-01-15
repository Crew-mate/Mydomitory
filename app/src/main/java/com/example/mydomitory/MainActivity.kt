package com.example.mydomitory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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
        signin_btn.setOnClickListener {
            //회원가입을 눌렀을 때 로그인이 되도록 함
            auth.createUserWithEmailAndPassword("s2212@e-mirim.hs.kr", "12341234")
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