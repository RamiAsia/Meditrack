package dev.ramiasia.meditrack.data.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "blood_pressure")
class BloodPressure(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,
    val systolic: Int,
    val diastolic: Int,
    val time: OffsetDateTime
)