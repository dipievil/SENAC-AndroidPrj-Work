package br.dipievil.senac_androidprj_work.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.dipievil.senac_androidprj_work.R
import br.dipievil.senac_androidprj_work.adapter.BookListAdapter
import br.dipievil.senac_androidprj_work.model.Book

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: BooksActivity
    private lateinit var rvBooks : RecyclerView

    var listAdapter : BookListAdapter? = null
    var linearLayoutManager : LinearLayoutManager? = null

    var books: List<Book> = ArrayList<Book>()


    override fun onCreate(savedInstanceState: Bundle?) {

        rvBooks = findViewById(R.id.rvBooks)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
    }
}