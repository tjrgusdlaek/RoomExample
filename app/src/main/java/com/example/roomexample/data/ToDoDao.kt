package com.example.roomexample.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {

    //suspend 메서드는 코루틴을 사용해서 호출을 해야됨
    @Insert
    suspend fun insert(vararg toDo: ToDo)

    @Update
    suspend fun update(toDo: ToDo)

    @Delete
    suspend fun delete(toDo: ToDo)

    //LiveData 로 관찰 가능한 데이터를 만들려면 LiveData<>로 감싸면됨 아니면 그냥 List<ToDo>
    @Query("SELECT * FROM ToDo")
    fun getAll(): LiveData<List<ToDo>>
}