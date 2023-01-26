package com.julianorenis.listacrud.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.julianorenis.listacrud.data.db.dao.ProdutoDao
import com.julianorenis.listacrud.data.db.entity.ProdutoEntity

@Database(entities = [ProdutoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract val produtoDAO: ProdutoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this){
                var instance: AppDatabase? = INSTANCE
                if(instance== null){
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,"app_database"
                    ).build()
                }
                return instance
            }
        }
    }
}