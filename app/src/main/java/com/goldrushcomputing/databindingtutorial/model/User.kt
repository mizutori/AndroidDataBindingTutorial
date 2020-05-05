package com.goldrushcomputing.databindingtutorial.model

import androidx.databinding.ObservableBoolean

data class User(
    var firstName: String,
    var lastName: String,
    var profileImageUrl: String,
    var isFriend: ObservableBoolean
)