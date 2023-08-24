package com.example.roomdatabse.data.state

import com.example.roomdatabse.data.entitiy.User

sealed class UserListState{
    object Idle:UserListState()
    object Loading:UserListState()
    object Empty:UserListState()
    class Result(val users:List<User>):UserListState()
    class Error(val throwable: Throwable):UserListState()
}
