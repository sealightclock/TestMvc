package com.example.jonathan.testmvc.controller

import androidx.compose.runtime.mutableStateListOf
import com.example.jonathan.testmvc.model.User

class UserController {
    private val _users = mutableStateListOf<User>()
    val users: List<User> = _users

    fun addUser(user: User) {
        _users.add(user)
    }

    fun removeUser(userId: Int) {
        _users.removeIf { it.id == userId }
    }
}
