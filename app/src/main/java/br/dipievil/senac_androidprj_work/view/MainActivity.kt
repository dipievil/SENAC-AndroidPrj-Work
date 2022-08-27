package br.dipievil.senac_androidprj_work.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.dipievil.senac_androidprj_work.R

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener{ view ->
            val intent = Intent(this, AreaActivity:: class.java)
            startActivity(intent)
        }
    }
}