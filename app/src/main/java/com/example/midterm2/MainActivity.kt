package com.example.midterm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.midterm2.ui.theme.Midterm2Theme
import com.example.midterm2.viewModel.DataLoaderViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: DataLoaderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Midterm2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text("User list")
                    Users()
                }
            }
        }
    }

    @Composable
    fun Users() {
        val usersObserver = viewModel.liveDataUsers.observeAsState()
        val users = usersObserver.value
        viewModel.loadUsers()

        LazyColumn {
            users?.let { users ->
                items(users.size) { index ->
                    Card {
                        Text(text = users[index].name)
                        Text(text = users[index].email)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
