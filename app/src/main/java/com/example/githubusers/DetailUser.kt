package com.example.githubusers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubusers.MainActivity.Companion.DETAIL_USER
import com.example.githubusers.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val users = intent.getParcelableExtra<User>(DETAIL_USER) as User

        binding.imgDetailPhoto.setImageResource(users.photo)
        binding.tvDetailName.text = users.name
        binding.tvDetailUsername.text = "@${users.username}"
        binding.tvDetailLocation.text = users.location
        binding.tvDetailFlag.text = users.flag
        binding.tvDetailFollowers.text = "${users.followers} Followers"
        binding.tvDetailFollowing.text = "${users.following} Following"
        binding.tvDetailRepository.text = "${users.repository} Repositories"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}