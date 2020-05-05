package com.goldrushcomputing.databindingtutorial

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import com.goldrushcomputing.databindingtutorial.databinding.ActivityMainBinding
import com.goldrushcomputing.databindingtutorial.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val firstName = "Benjamin"
        val lastName = "Franklin"
        val profileImageUrl =
            "https://upload.wikimedia.org/wikipedia/commons/2/25/Benjamin_Franklin_by_Joseph_Duplessis_1778.jpg"
        val user = User(firstName, lastName, profileImageUrl, ObservableBoolean(false))
        binding.user = user
        binding.handler = this
    }

    //メソッド参照
    fun onClickSend(view: View) {
        val msg = "Sending..."
        Toast.makeText(
            this, msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    //リスナーバインディング１
    fun onClickInvite(user: User) {
        val msg = "Inviting ${user.firstName} ..."
        Toast.makeText(
            this, msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    //リスナーバインディング２
    fun onClickLike(user: User) {
        val msg = "Liking ${user.firstName}'s post..."
        Toast.makeText(
            this, msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    //リスナーバインディング３
    fun onClickShare(view: View, user: User) {
        val msg = "Sharing to ${user.firstName} ..."
        Toast.makeText(
            this, msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun onCheckFriend(user: User) {
        //isFriendの値をトグルする
        user.isFriend.set(!user.isFriend.get())
    }
}
