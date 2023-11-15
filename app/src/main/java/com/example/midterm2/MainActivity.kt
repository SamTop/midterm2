package com.example.midterm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Card (modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                    ) {
                            Text(
                                text = users[index].name,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Text(
                                text = users[index].email,
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
