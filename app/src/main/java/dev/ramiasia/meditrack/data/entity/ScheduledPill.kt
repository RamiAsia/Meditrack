package dev.ramiasia.meditrack.data.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Entity(tableName = "pill_table")
data class ScheduledPill(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val pillId: Long = 0,
    val name: String?,
    val taken: Boolean? = false,
    val time: OffsetDateTime?
)