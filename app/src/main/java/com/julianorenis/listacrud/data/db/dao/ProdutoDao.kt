package com.julianorenis.listacrud.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.julianorenis.listacrud.data.db.entity.ProdutoEntity

@Dao
interface ProdutoDao {

    @Insert
    suspend fun  insert(produto: ProdutoEntity):Long

    @Update
    suspend fun  update(produto: ProdutoEntity)

    @Query("DELETE FROM produto WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM produto")
    suspend fun  deleteAll()

    @Query("SELECT * FROM produto")
    fun getAll(): LiveData<List<ProdutoEntity>>
}