package com.example.jonathan.testmvc.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jonathan.testmvc.controller.UserController
import com.example.jonathan.testmvc.model.User

@Composable
fun UserScreen(controller: UserController) {
    val users = remember { controller.users }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("User List", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {
            items(users) { user ->
                UserItem(user = user, onRemove = { controller.removeUser(user.id) })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val newUser = User(
                id = (users.size + 1),
                name = "User ${users.size + 1}",
                email = "user${users.size + 1}@example.com"
            )
            controller.addUser(newUser)
        }) {
            Text("Add User")
        }
    }
}

@Composable
fun UserItem(user: User, onRemove: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("${user.name} (${user.email})")
        Button(onClick = onRemove) {
            Text("Remove")
        }
    }
}
