package com.julianorenis.listacrud.repository

import androidx.lifecycle.LiveData
import com.julianorenis.listacrud.data.db.dao.ProdutoDao
import com.julianorenis.listacrud.data.db.entity.ProdutoEntity

class DatabaseDataSource(
    private val produtoDao: ProdutoDao
) : ProdutoRepository {
    override suspend fun insertProduto(
        nameProduto: String,
        marca: String,
        preco: Double,
        un: Int
    ): Long {
        val produtos = ProdutoEntity(
            nameProduto = nameProduto,
            marca = marca,
            preco = preco,
            un = un
        )
        return produtoDao.insert(produtos)
    }

    override suspend fun updateProduto(
        id: Long,
        nameProduto: String,
        marca: String,
        preco: Double,
        un: Int
    ) {
        val produtos = ProdutoEntity(
            id = id,
            nameProduto = nameProduto,
            marca = marca,
            preco = preco,
            un = un
        )
        produtoDao.update(produtos)
    }

    override suspend fun deleteProduto(id: Long) {
        produtoDao.delete(id)
    }

    override suspend fun deleteAllProdutos() {
        produtoDao.deleteAll()
    }

    override suspend fun getAllProdutos(): LiveData<List<ProdutoEntity>> {
       return  produtoDao.getAll()
    }
}