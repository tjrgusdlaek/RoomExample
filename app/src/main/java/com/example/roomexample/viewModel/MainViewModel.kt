package com.example.roomexample.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.roomexample.data.AppDatabase
import com.example.roomexample.data.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name")
        .build()

    var todos : LiveData<List<ToDo>>
    var newTodo : String ? =null

    //맨 처음 초기화 할때 한번 호출하는 것
    init {
        todos = getAll()
    }

    private fun getAll() : LiveData<List<ToDo>>{
        return db.toDoDao().getAll()
    }


     fun insert(toDo: String){
        viewModelScope.launch(Dispatchers.IO) {
            db.toDoDao().insert(ToDo(toDo))
        }
    }
}