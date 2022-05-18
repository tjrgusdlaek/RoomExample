package com.example.roomexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ToDo(var title: String?){
    @PrimaryKey (autoGenerate = true)var id: Int =0
}

