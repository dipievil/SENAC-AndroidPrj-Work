package br.dipievil.senac_androidprj_work.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.dipievil.senac_androidprj_work.R

class AreaActivity : AppCompatActivity() {

    private lateinit var btnBooks : Button
    private lateinit var btnUsers : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        btnBooks = findViewById(R.id.btnBooks)
        btnUsers = findViewById(R.id.btnUsers)

        btnBooks.setOnClickListener{ view ->
            val intent = Intent(this, BooksActivity:: class.java)
            startActivity(intent)
        }

        btnUsers.setOnClickListener{ view ->
            val intent = Intent(this, UsersActivity:: class.java)
            startActivity(intent)
        }

    }
}