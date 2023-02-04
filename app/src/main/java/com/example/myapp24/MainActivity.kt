package com.example.myapp24

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp24.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var user1 = ArrayList<User>()
    private var productsAdapter = UsersAdapter(user1)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecyclerView()
        initListeners()
    }
    private fun initRecyclerView(){
        binding.recyclerUsers.adapter = productsAdapter
        binding.recyclerUsers.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)


    }

    private fun initListeners(){
        binding.btnGetUsers.setOnClickListener {
            WebThread(ProductHandler()).execute(null)
        }


    }






    inner class ProductHandler : Handler(){
        @SuppressLint("NotifyDataSetChanged")
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if(msg.obj != null){
                var productsPR = msg.obj as UserResponse
                this@MainActivity.user1.addAll(productsPR.users)
                productsAdapter.notifyDataSetChanged()
            }
        }
    }


}