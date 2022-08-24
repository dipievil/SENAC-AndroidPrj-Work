package br.dipievil.senac_androidprj_work.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.dipievil.senac_androidprj_work.R
import br.dipievil.senac_androidprj_work.model.User

class UserListAdapter(private val users: MutableList<User>) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    //Create the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_users,
            parent,
            false)
        return ViewHolder(view);
    }

    //Receive the values
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.tvName.text = user.name

        if(position%2==0)
            holder.layout.setBackgroundColor(Color.rgb(240,240,240))
        else
            holder.layout.setBackgroundColor(Color.rgb(255,255,255))

        holder.btnViewUserOptions.setOnClickListener{
            Log.i("Info","Clicou no botão")
        }
    }

    override fun getItemCount(): Int {
        return this.users.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tvName : TextView = view.findViewById(R.id.tvName)
        var btnViewUserOptions : TextView = view.findViewById(R.id.btnViewUserOptions)
        var layout: LinearLayout = view.findViewById(R.id.linearLayout)
    }
}