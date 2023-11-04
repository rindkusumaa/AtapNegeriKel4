package com.rindakusuma.atapnegerikel4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity {
    class LoginActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            val etUsername = findViewById<EditText>(R.id.et_username)
            val etPassword = findViewById<EditText>(R.id.et_password)

            val btnLogin = findViewById<Button>(R.id.btn_login)
            btnLogin.setOnClickListener {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()

                fun onRegisterClick(view: View) {
                    // Buka aktivitas register
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                }

                fun onLoginClick(view: View) {
                    val username = etUsername.text.toString()
                    val password = etPassword.text.toString()

                    // Cek apakah user sudah login
                    val firebaseUser = FirebaseAuth.getInstance().currentUser
                    if (firebaseUser != null) {
                        // User sudah login, lanjut ke activity utama
                        finish()
                    } else {
                        // User belum login, lakukan login
                        // ...
                    }
                }



                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Registrasi sekarang!", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val auth = FirebaseAuth.getInstance()
                    auth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Login berhasil
                                Toast.makeText()
                            }
                        }

                }
            }
        }
    }
}