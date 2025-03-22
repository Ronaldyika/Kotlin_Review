package com.example.test_learn.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.test_learn.Data.Card
import com.example.test_learn.Data.cardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class cardViewModel(private val cardRepository: cardRepository) : ViewModel() {

    private val _cards = MutableStateFlow(
        emptyList<Card>()
    )

    val card:StateFlow<List<Card>> = _cards

    init {
        viewModelScope.launch {
            _cards.value = cardRepository.getCards()
        }
    }
}



class CardViewModelFactory(private val repository: cardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(cardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return cardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}