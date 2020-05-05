package com.goldrushcomputing.databindingtutorial.model

import android.provider.ContactsContract
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

data class User(
    var firstName: String,
    var lastName: String,
    var profileImageUrl: String,
    var isFriend: ObservableBoolean,
    var nickname: ObservableField<String>
)