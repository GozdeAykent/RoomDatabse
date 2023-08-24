package com.example.roomdatabse.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabse.data.entitiy.User
import com.example.roomdatabse.databinding.UserListItemBinding

class UsersAdapter(private val context: Context,private val users:List<User>):RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {
    class MyViewHolder(binding: UserListItemBinding):RecyclerView.ViewHolder(binding.root) {

        val tvName=binding.tvName
        val tvSurname=binding.tvSurname
        val tvEmail=binding.tvEmail
        val tvPassword=binding.tvPassword

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(UserListItemBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user=users[position]
        with(user){
            holder.tvName.text=name
            holder.tvSurname.text=surname
            holder.tvEmail.text=email
            holder.tvPassword.text=password
        }
    }
}
