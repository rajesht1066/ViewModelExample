package com.example.viewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelDemo:ViewModel() {

//    //ViewModel
//    var num = 0
//    fun increment(){
//        num+=1
//    }

//    //With MutableLiveData
//    val number = MutableLiveData<Int>()
//    val str = MutableLiveData<String>()
//    init {
//        number.value = 0
//        str.value = "Rajesh"
//    }
//    fun increment(){
//        number.value=number.value?.plus(1)
//        str.value=str.value+"h"
//    }

    //With Immutable - LiveData
    // We want our members not to be changed in activity file. At the same time we want the observable to work on it
    // Make it private and for observable create LiveData(Immutable) to access members(Mutable one's) when changing
    private val number = MutableLiveData<Int>()
    val numberLiveData : LiveData<Int>
        get() = number

    init {
        number.value = 0
    }
    fun increment(){
        number.value=number.value?.plus(1)
    }
}