package dev.ramiasia.meditrack.data.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "pill_table")
data class PillIngestion(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val pillId: Long = 0,
    val name: String?,
    val time: OffsetDateTime?
)