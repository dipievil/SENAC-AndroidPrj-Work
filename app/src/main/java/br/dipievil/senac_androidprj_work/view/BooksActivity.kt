package br.dipievil.senac_androidprj_work.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.dipievil.senac_androidprj_work.R
import br.dipievil.senac_androidprj_work.adapter.BookListAdapter
import br.dipievil.senac_androidprj_work.model.Book
import br.dipievil.senac_androidprj_work.repository.BookRepository

class BooksActivity : AppCompatActivity() {

    private lateinit var rvBooks : RecyclerView

    var viewAdapter : BookListAdapter? = null
    var linearLayoutManager : LinearLayoutManager? = null

    var books: MutableList<Book> = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
    }

    override fun onResume() {
        super.onResume()

        viewAdapter = BookListAdapter(books, this)

        rvBooks = findViewById(R.id.rvBook)

        val dbHandler = BookRepository()
        books = dbHandler.getBooks()

        rvBooks.layoutManager = LinearLayoutManager(this)
        rvBooks.adapter = viewAdapter

        linearLayoutManager = LinearLayoutManager(this)
    }
}