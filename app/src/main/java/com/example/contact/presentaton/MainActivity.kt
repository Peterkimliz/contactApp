package com.example.contact.presentaton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
//    private val db by lazy {
//
//        Room.databaseBuilder(
//            applicationContext,
//            ContactDatabase::class.java, "contact.db"
//        ).build()
//    }
//    private val viewModel by viewModels<ContactViewModel>(
//        factoryProducer = {
//            object : ViewModelProvider.Factory {
//                override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                    return ContactViewModel(db.dao) as T
//                }
//            }
//        }
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val state by viewModel.state.collectAsState()
//                    HomePage(state =state, onEvent =viewModel::onEvent)
                }
            }
        }
    }
}

