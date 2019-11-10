package dev.ramiasia.meditrack.data

import androidx.lifecycle.LiveData
import androidx.room.*
import dev.ramiasia.meditrack.data.entity.BloodPressure
import dev.ramiasia.meditrack.data.entity.HeartRate
import dev.ramiasia.meditrack.data.entity.ScheduledMedication
import dev.ramiasia.meditrack.data.entity.PillIngestion

@Dao
interface MetricDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pillIngestion: PillIngestion): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(scheduledMedication: ScheduledMedication): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(heartRate: HeartRate): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bloodPressure: BloodPressure): Long

    //Ingestions
    @Query("SELECT * FROM pill_table ORDER BY pillId ASC")
    fun getAllIngestions(): LiveData<List<PillIngestion>>

    @Delete
    fun deletePillIngestion(ingestion: PillIngestion)

    @Query("DELETE FROM pill_table")
    fun deleteAllPillIngestions()


    //Blood pressure
    @Query("SELECT * FROM blood_pressure ORDER BY id ASC")
    fun getAllBloodPressureRecords(): LiveData<List<BloodPressure>>

    @Delete
    fun deleteBloodPressureRecord(bloodPressure: BloodPressure)

    @Query("DELETE FROM blood_pressure")
    fun deleteAllBloodPressureRecords()


    //Heart rate
    @Query("SELECT * FROM heart_rate ORDER BY id ASC")
    fun getAllHeartRateRecords(): LiveData<List<BloodPressure>>

    @Delete
    fun deleteHeartRate(heartRate: HeartRate)

    @Query("DELETE from heart_rate")
    fun deleteAllHeartRateRecords()


    //Medication schedule
    @Query("SELECT * FROM scheduled_medication ORDER BY id ASC")
    fun getMedicationSchedule(): LiveData<List<ScheduledMedication>>

    @Delete
    fun deleteScheduledMedication(scheduledMedication: ScheduledMedication)

    @Query("DELETE from scheduled_medication")
    fun deleteAllScheduledMedication()
}