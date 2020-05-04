package com.goldrushcomputing.databindingtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.goldrushcomputing.databindingtutorial.databinding.ActivityMainBinding
import com.goldrushcomputing.databindingtutorial.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val user = User("Benjamin")
        binding.user = user
    }
}
