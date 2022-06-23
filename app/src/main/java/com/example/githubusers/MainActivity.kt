package com.example.githubusers

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var  rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUser)
        showRecylerList()
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUsers.layoutManager = LinearLayoutManager(this)
        }
    }

    private val listUser: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataUsername = resources.getStringArray(R.array.data_username)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val dataLocation = resources.getStringArray(R.array.data_location)
            val dataFlag = resources.getStringArray(R.array.data_flag)
            val dataFollowers = resources.getStringArray(R.array.data_followers)
            val dataFollowing = resources.getStringArray(R.array.data_following)
            val dataRepo = resources.getStringArray(R.array.data_repository)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user =  User(dataName[i],
                            dataUsername[i],
                            dataPhoto.getResourceId(i, -1),
                            dataLocation[i],
                            dataFlag[i],
                            dataFollowers[i],
                            dataFollowing[i],
                            dataRepo[i])
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecylerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter =listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                showSeletedUser(data)
            }
        })
    }


    private fun showSeletedUser(user: User) {
        Toast.makeText(this, "Detail User " + user.name, Toast.LENGTH_SHORT).show()



        val IntentDetailUser = Intent(this@MainActivity, DetailUser::class.java)
        IntentDetailUser.putExtra(DETAIL_USER, user)
        startActivity(IntentDetailUser)
    }

    companion object{
        val DETAIL_USER = "detail_user"
    }

}