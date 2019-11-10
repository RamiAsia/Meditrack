package dev.ramiasia.meditrack.data.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "scheduled_medication")
class ScheduledMedication(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Long = 0,
    val medName: String?,
    val time: OffsetDateTime?,
    val pillCount: Int?
)