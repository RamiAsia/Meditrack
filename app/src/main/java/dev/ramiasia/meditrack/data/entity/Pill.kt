package dev.ramiasia.meditrack.data.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pill_table")
class Pill(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val pillId: Long = 0,
    val name: String?,
    val taken: Boolean? = false
)