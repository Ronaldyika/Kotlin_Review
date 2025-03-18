package com.example.test_learn.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

private const val _price_of_olives = 5

class Task3ViewModel: ViewModel() {

//    getting the number of items
    private val _quantity = mutableStateOf(0)

//    get total amount
    private val _totalamount = mutableStateOf(0)

    fun increaseQauntity(){

        _quantity.value += 1
    }

    fun dicreaseQauntity(){

        if (_quantity.value == 0){
            _quantity.value = 0
        }else{
            _quantity.value -= 1
        }

    }

    fun checkout(){
        _totalamount.value = _price_of_olives*_quantity.value
    }


//    getting the price of product
}