package br.dipievil.senac_androidprj_work.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.dipievil.senac_androidprj_work.R
import br.dipievil.senac_androidprj_work.model.Book


class BookListAdapter(private val books: MutableList<Book>, internal val context: Context) :
    RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    //Create the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_books,
            parent,
            false)
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

        val popup = PopupMenu(context, holder.btnViewMenu)

        holder.btnViewMenu.setOnClickListener{
            popup.inflate(R.menu.book_options_menu)

                fun onMenuItemClick(item: MenuItem): Boolean {
                    when (item.getItemId()) {
                        R.id.menu1 -> {
                            Toast.makeText(context, "Menu 1", Toast.LENGTH_LONG).show()                        }
                        R.id.menu2 -> {
                            Toast.makeText(context, "Menu 2", Toast.LENGTH_LONG).show()
                        }
                        R.id.menu3 -> {
                            Toast.makeText(context, "Menu 3", Toast.LENGTH_LONG).show()
                        }
                    }
                    return false
                }

            popup.show()
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