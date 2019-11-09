package dev.ramiasia.meditrack.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.ramiasia.meditrack.data.entity.ScheduledPill

@Dao
interface PillDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(scheduledPill: ScheduledPill) : Long

    @Query("DELETE FROM pill_table")
    fun deleteAll()

    @Query("SELECT * FROM pill_table ORDER BY pillId ASC")
    fun getAllPills() : LiveData<List<ScheduledPill>>
}