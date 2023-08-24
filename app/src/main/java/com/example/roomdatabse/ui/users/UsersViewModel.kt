package com.example.roomdatabse.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabse.data.AppDatabase
import com.example.roomdatabse.data.state.UserListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class UsersViewModel:ViewModel() {
    private val _userListState:MutableStateFlow<UserListState> = MutableStateFlow(UserListState.Idle)
    val userListState:StateFlow<UserListState> = _userListState


    fun getAllUsers(appDatabase: AppDatabase) {

        viewModelScope.launch {
            runCatching {
                val users=appDatabase.userDao().getAllUsers()
                _userListState.value=UserListState.Result(users)
            }.onFailure {
                _userListState.value=UserListState.Error(it)
            }
        }
    }
}

//INSERT INTO table_name
//VALUES (value1, value2, value3, ...);