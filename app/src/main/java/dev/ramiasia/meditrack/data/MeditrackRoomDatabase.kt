package dev.ramiasia.meditrack.data

import android.content.Context
import androidx.room.*
import dev.ramiasia.meditrack.data.entity.BloodPressure
import dev.ramiasia.meditrack.data.entity.HeartRate
import dev.ramiasia.meditrack.data.entity.MedicationSchedule
import dev.ramiasia.meditrack.data.entity.ScheduledPill
import dev.ramiasia.meditrack.util.DataTypeConverter

@Database(
    entities = arrayOf(
        ScheduledPill::class,
        MedicationSchedule::class,
        BloodPressure::class,
        HeartRate::class
    ), version = 1, exportSchema = true
)
@TypeConverters(DataTypeConverter::class)
abstract class MeditrackRoomDatabase : RoomDatabase() {

    abstract fun metricDao(): MetricDao

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

