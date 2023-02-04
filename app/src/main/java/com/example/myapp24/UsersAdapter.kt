package com.example.myapp24

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapp24.databinding.UserItemBinding

class UsersAdapter (
    var users : ArrayList<User>
): RecyclerView.Adapter<UsersAdapter.UserViewHolder>(){
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var userItemBinding : UserItemBinding= UserItemBinding.bind(itemView)

    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item,null)
        )
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userItemBinding.txtFstName.text = "${users[position].firstName}"
        holder.userItemBinding.txtLstName.text = "${users[position].lastName}"
        holder.userItemBinding.txtAge.text = "${users[position].age}"




//        holder.userItemBinding.txtFstName.setOnClickListener{
//            class Products : AppCompatActivity(){
//                var useIntent = Intent(this,UserDetails::class.java)
//                override fun startActivity(useIntent: Intent) {
//                    useIntent.putExtra("users",users)
//                    super.startActivity(useIntent)
//                }
//
//            }
//
//        }
    }

}