package br.dipievil.senac_androidprj_work.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.dipievil.senac_androidprj_work.R
import br.dipievil.senac_androidprj_work.model.Book

class BookListAdapter(private val books: List<Book>, internal val context: Context,
                  private val callbacks: (Int,String) -> Unit) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    //Create the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_books, parent, false)
        return ViewHolder(view);
    }

    //Receive the values
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.tvTitle.text = book.title
        holder.tvAuthor.text = book.pages.toString()


        if(position%2==0)
            holder.layout.setBackgroundColor(Color.rgb(240,240,240))
        else
            holder.layout.setBackgroundColor(Color.rgb(255,255,255))

        holder.btnViewMenu.setOnClickListener{
            this.callbacks(position,"editar")
        }
    }

    override fun getItemCount(): Int {
        return this.books.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tvTitle : TextView = view.findViewById(R.id.tvBookName)
        var tvAuthor : TextView = view.findViewById(R.id.tvBookAuthor)
        var btnViewMenu : TextView = view.findViewById(R.id.btnViewOptions)
        var layout: LinearLayout = view.findViewById(R.id.linearLayout)
    }
}