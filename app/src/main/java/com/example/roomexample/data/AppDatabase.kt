package com.example.roomexample.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDo::class], version = 1, exportSchema = false)
abstract  class AppDatabase :RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}