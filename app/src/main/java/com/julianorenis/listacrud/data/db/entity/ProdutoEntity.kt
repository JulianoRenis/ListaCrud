package com.julianorenis.listacrud.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")
class ProdutoEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    val nameProduto: String,
    val marca:String,
    val preco: Double,
    val un : Int
        )



