package br.dipievil.senac_androidprj_work.repository

import android.util.Log
import br.dipievil.senac_androidprj_work.model.Book
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class bookRepository : dbHandler() {

    fun addBook(book: Book) : Boolean{
        var db = Firebase.firestore

        var addStatus = true;


        db.collection("Livros")
            .add(book)
            .addOnSuccessListener { documentReference ->
                Log.d("FIREBASE", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("FIREBASE", "Error adding document", e)
                addStatus = false;
            }
        return addStatus;
    }

    fun getBooks() : MutableList<Book> {

        var books: MutableList<Book> = mutableListOf()

        var db = Firebase.firestore

        db.collection("livros")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    var id = document.id as String
                    var status = document.data.getValue("status") as String
                    var title = document.data.getValue("title") as String
                    var author = document.data.getValue("author") as String
                    var subtitle = document.data.getValue("subtitle") as String
                    var volume = document.data.getValue("volume") as Int
                    var publisher = document.data.getValue("publisher") as String
                    var year = document.data.getValue("year") as String
                    var area = document.data.getValue("area") as String
                    var genre = document.data.getValue("genre") as String
                    var isbn = document.data.getValue("isbn") as String
                    var cdd = document.data.getValue("cdd") as String
                    var acquisition = document.data.getValue("acquisition") as String
                    var pages = document.data.getValue("pages") as Int
                    var subgenre = document.data.getValue("subgenre") as String
                    var edition = document.data.getValue("edition") as Int

                    val dbBook = Book(id,title,subtitle,volume, edition,year,publisher,area,
                        genre,subgenre,isbn,cdd, acquisition,status,author,pages)

                    books!!.add(dbBook)
                }
            }
            .addOnFailureListener { exception ->
                Log.e("error", "Error getting documents: ", exception)
            }

        return books;
    }
}