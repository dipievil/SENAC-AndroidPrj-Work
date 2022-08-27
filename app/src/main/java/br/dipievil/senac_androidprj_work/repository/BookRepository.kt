package br.dipievil.senac_androidprj_work.repository

import android.util.Log
import br.dipievil.senac_androidprj_work.model.Book
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BookRepository : DbHandler() {

    fun addBook(book: Book) : Boolean{
        var db = Firebase.firestore

        var addStatus = true;

        db.collection(COLLECTION_NAME)
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

    fun deleteBook(id : String){
        var db = Firebase.firestore

        db.collection(COLLECTION_NAME)
            .document(id)
            .delete()
            .addOnSuccessListener { Log.d("FIREBASE", "DocumentSnapshot successfully deleted!") }
            .addOnFailureListener { e -> Log.w("FIREBASE", "Error deleting document", e) }
    }

    fun getBooks() : MutableList<Book> {

        var books: MutableList<Book> = mutableListOf()

        var db = Firebase.firestore

        db.collection(COLLECTION_NAME)
            .orderBy("Título", Query.Direction.DESCENDING).get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    var id = document.id as String
                    var status = document.data.getValue("Status") as String
                    var title = document.data.getValue("Título") as String
                    var author = document.data.getValue("Autor") as String
                    var subtitle = document.data.getValue("Sub-título") as String
                    var volume = document.data.getValue("Volume") as Int
                    var publisher = document.data.getValue("Editora") as String
                    var year = document.data.getValue("Ano") as String
                    var area = document.data.getValue("Área") as String
                    var genre = document.data.getValue("Gênero") as String
                    var subgenre = document.data.getValue("Subgênero") as String
                    var isbn = document.data.getValue("ISBN") as String
                    var cdd = document.data.getValue("CDD") as String
                    var acquisition = document.data.getValue("Aquisição") as String
                    var pages = document.data.getValue("Páginas") as Int
                    var edition = document.data.getValue("Edição") as Int

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

    companion object{
        val COLLECTION_NAME = "Livros"
    }
}