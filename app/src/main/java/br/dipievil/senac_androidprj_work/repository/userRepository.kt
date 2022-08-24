package br.dipievil.senac_androidprj_work.repository

import android.util.Log
import br.dipievil.senac_androidprj_work.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class userRepository :dbHandler() {


    fun addUser(user: User) : Boolean{
        var db = Firebase.firestore

        var addStatus = true;

        db.collection("Livros")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("FIREBASE", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("FIREBASE", "Error adding document", e)
                addStatus = false;
            }
        return addStatus;
    }


    fun getUsers() : MutableList<User> {

        var users: MutableList<User> = mutableListOf()

        var db = Firebase.firestore

        db.collection("usuários")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    var id = document.id as String
                    var name = document.data.getValue("name") as String
                    var address = document.data.getValue("address") as String
                    var cpf = document.data.getValue("cpf") as String
                    var phone = document.data.getValue("phone") as String
                    var email = document.data.getValue("email") as String

                    val dbUser = User(id,name,address,cpf,phone,email)

                    users!!.add(dbUser)
                }
            }
            .addOnFailureListener { exception ->
                Log.e("error", "Error getting documents: ", exception)
            }

        return users;
    }

    fun deleteUser() : Boolean{
        return true;
    }
}