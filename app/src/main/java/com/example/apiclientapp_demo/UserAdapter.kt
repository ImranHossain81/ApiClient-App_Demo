package com.example.apiclientapp_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.auth.User

class UserAdapter (private val userList: List<UserD>): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    private val idtxt = itemView.findViewById<TextView>(R.id.idtxt)
    private val nametxt = itemView.findViewById<TextView>(R.id.nametxt)
    private val usernametxt = itemView.findViewById<TextView>(R.id.usernametxt)
    private val emailtxt = itemView.findViewById<TextView>(R.id.emailtxt)

    fun bind(user:UserD){
        idtxt.text = user.userid.toString()
        nametxt.text = user.name
        usernametxt.text = user.username
        emailtxt.text = user.email
    }

}