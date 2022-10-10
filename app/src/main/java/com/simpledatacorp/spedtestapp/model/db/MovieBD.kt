package com.simpledatacorp.spedtestapp.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity

@TypeConverters(value = [MovieTypeConverter::class])
@Database(entities = arrayOf(MovieEntity::class), version = 1)
abstract class MovieBD : RoomDatabase() {
    abstract fun dao(): MovieDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MovieBD? = null

        fun getDatabase(context: Context): MovieBD {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieBD::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}