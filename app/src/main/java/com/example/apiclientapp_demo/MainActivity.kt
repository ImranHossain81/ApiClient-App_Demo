package com.example.apiclientapp_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.auth.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        userAdapter = UserAdapter(emptyList())
        recyclerView.adapter = userAdapter

        fetchData()
    }

    private fun fetchData() {
        val call = ApiClient.apiService.getUsers()
        call.enqueue(object: Callback<List<UserD>> {
            override fun onResponse(call: Call<List<UserD>>, response: Response<List<UserD>>) {
                if(response.isSuccessful){
                    val users = response.body()?: emptyList()
                    userAdapter = UserAdapter(users)
                    recyclerView.adapter = userAdapter
                }
            }

            override fun onFailure(call: Call<List<UserD>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Data Fetehing failed", Toast.LENGTH_SHORT).show()
            }

        })
    }
}