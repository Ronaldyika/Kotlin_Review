package com.example.test_learn.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.test_learn.Data.cardRepository
import com.example.test_learn.ViewModel.CardViewModelFactory
import com.example.test_learn.ViewModel.cardViewModel
import com.example.test_learn.ui.components.CardTask
@Composable
fun CardList(
    modifier: Modifier = Modifier,
    cardViewModel: cardViewModel // ✅ Correct parameter type
) {
    val cards by cardViewModel.card.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(cards) { card ->
            CardTask(name = card.name, largeUrl = card.largeUrl, job = card.job)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
