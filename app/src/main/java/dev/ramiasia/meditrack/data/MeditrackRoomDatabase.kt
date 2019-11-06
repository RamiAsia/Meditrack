package dev.ramiasia.meditrack.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.ramiasia.meditrack.data.entity.Pill

@Database(entities = arrayOf(Pill::class), version = 1, exportSchema = true)
abstract class MeditrackRoomDatabase : RoomDatabase() {

    abstract fun pillDao(): PillDao

    companion object {
        @Volatile
        private var instance: MeditrackRoomDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, MeditrackRoomDatabase::class.java, "meditrack.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}