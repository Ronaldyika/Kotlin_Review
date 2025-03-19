package com.example.test_learn.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.test_learn.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val _price_of_olives = 5

var imageId = R.drawable.tree

class Task3ViewModel: ViewModel() {

//    getting the number of items
    private val _quantity = MutableStateFlow(0)
    val quantity:StateFlow<Int> = _quantity

//    get total amount
    private val _totalamount = MutableStateFlow(0)
    val totol_amount:StateFlow<Int> = _totalamount

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