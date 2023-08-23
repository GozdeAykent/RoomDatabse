package com.example.roomdatabse.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabse.data.entitiy.User

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)


    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>
}