package dev.ramiasia.meditrack.data.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "heart_rate")
class HeartRate(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,
    val heartRate: Int,
    val time: OffsetDateTime
)