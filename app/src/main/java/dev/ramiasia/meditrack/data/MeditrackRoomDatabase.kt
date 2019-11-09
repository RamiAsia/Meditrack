package dev.ramiasia.meditrack.data

import android.content.Context
import androidx.room.*
import dev.ramiasia.meditrack.data.entity.MedicationSchedule
import dev.ramiasia.meditrack.data.entity.ScheduledPill
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Database(entities = arrayOf(ScheduledPill::class, MedicationSchedule::class), version = 1, exportSchema = true)
@TypeConverters(OffsetDateTimeConverters::class)
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

object OffsetDateTimeConverters {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?) : OffsetDateTime? {
        return value?.let {
            return formatter.parse(it, OffsetDateTime::from)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(value: OffsetDateTime?) : String? {
        return value?.format(formatter)
    }
}