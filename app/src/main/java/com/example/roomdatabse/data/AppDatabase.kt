package com.example.roomdatabse.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabse.data.dao.UserDao
import com.example.roomdatabse.data.entitiy.User


@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao():UserDao
}