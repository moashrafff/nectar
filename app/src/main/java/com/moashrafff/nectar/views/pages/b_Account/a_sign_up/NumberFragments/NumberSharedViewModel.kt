package com.moashrafff.nectar.views.pages.b_Account.a_sign_up.NumberFragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberSharedViewModel : ViewModel() {

    val message = MutableLiveData<String>()
    val number = MutableLiveData<String>()

    fun sendMessage(text: String) {
        message.value = text
    }

    fun sendNumber(text: String) {
        number.value = text
    }
}