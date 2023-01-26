package com.julianorenis.listacrud.repository

import androidx.lifecycle.LiveData
import com.julianorenis.listacrud.data.db.entity.ProdutoEntity

interface ProdutoRepository {

    suspend fun insertProduto(nameProduto :String, marca: String, preco: Double,un: Int):Long

    suspend fun updateProduto(id: Long,nameProduto :String, marca: String, preco: Double,un: Int)

    suspend fun deleteProduto(id: Long)

    suspend fun deleteAllProdutos()

    suspend fun getAllProdutos(): LiveData<List<ProdutoEntity>>

}