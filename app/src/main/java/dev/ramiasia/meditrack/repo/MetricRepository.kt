package dev.ramiasia.meditrack.repo

import android.app.Application
import androidx.lifecycle.LiveData
import dev.ramiasia.meditrack.data.MeditrackRoomDatabase
import dev.ramiasia.meditrack.data.MetricDao
import dev.ramiasia.meditrack.data.entity.BloodPressure
import dev.ramiasia.meditrack.data.entity.HeartRate
import dev.ramiasia.meditrack.data.entity.PillIngestion
import dev.ramiasia.meditrack.data.entity.ScheduledMedication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * Repository for the user's metric data.
 */
class MetricRepository(application: Application) {

    private var db : MeditrackRoomDatabase = MeditrackRoomDatabase.invoke(application)
    private var metricDao: MetricDao = db.metricDao()
    var pills: LiveData<List<PillIngestion>> = metricDao.getAllIngestions()
        private set

    /**
     * Inserts a new [PillIngestion] record.
     *
     * @param pillIngestion Ingestion object to be inserted into db.
     */
    fun insert(pillIngestion: PillIngestion) {
        CoroutineScope(IO).launch {
            metricDao.insert(pillIngestion)
        }
    }

    /**
     * Inserts a new [BloodPressure] record.
     *
     * @param bloodPressure Blood pressure object to be inserted into db.
     */
    fun insert(bloodPressure: BloodPressure) {
        CoroutineScope(IO).launch {
            metricDao.insert(bloodPressure)
        }
    }

    /**
     * Inserts a new [HeartRate] record.
     *
     * @param heartRate Heart rate object to be inserted into db.
     */
    fun insert(heartRate: HeartRate) {
        CoroutineScope(IO).launch {
            metricDao.insert(heartRate)
        }
    }

    /**
     * Inserts a new [ScheduledMedication] record.
     *
     * @param scheduledMedication   Scheduled medication object to be inserted into db.
     */
    fun insert(scheduledMedication: ScheduledMedication) {
        CoroutineScope(IO).launch {
            metricDao.insert(scheduledMedication)
        }
    }

    /**
     * Deletes a [PillIngestion] object.
     *
     * @param pillIngestion Pill ingestion object to be deleted.
     */
    fun delete(pillIngestion: PillIngestion) {
        CoroutineScope(IO).launch {
            metricDao.deletePillIngestion(pillIngestion)
        }
    }

    /**
     * Deletes a [BloodPressure] object.
     *
     * @param bloodPressure Blood pressure object to be deleted.
     */
    fun delete(bloodPressure: BloodPressure) {
        CoroutineScope(IO).launch {
            metricDao.deleteBloodPressureRecord(bloodPressure)
        }
    }

    /**
     * Deletes a [HeartRate] object.
     *
     * @param heartRate Heart rate object to be deleted.
     */
    fun delete(heartRate: HeartRate) {
        CoroutineScope(IO).launch {
            metricDao.deleteHeartRate(heartRate)
        }
    }

    /**
     * Deletes a [ScheduledMedication] object.
     *
     * @param scheduledMedication   Scheduled medication object to be deleted.
     */
    fun deleteScheduledMedication(scheduledMedication: ScheduledMedication) {
        CoroutineScope(IO).launch {
            metricDao.deleteScheduledMedication(scheduledMedication)
        }
    }

    /**
     * Deletes all [PillIngestion] objects in the db.
     */
    fun deleteAllPillIngestions() {
        CoroutineScope(IO).launch {
            metricDao.deleteAllPillIngestions()
        }
    }

    /**
     * Deletes all [BloodPressure] objects in the db.
     */
    fun deleteAllBloodPressureREcords() {
        CoroutineScope(IO).launch {
            metricDao.deleteAllBloodPressureRecords()
        }
    }

    /**
     * Deletes all [HeartRate] objects in the db.
     */
    fun deleteAllHeartRateRecords() {
        CoroutineScope(IO).launch {
            metricDao.deleteAllHeartRateRecords()
        }
    }

    /**
     * Deletes all [ScheduledMedication] objects in the db.
     */
    fun deleteAllScheduledMedicationRecords() {
        CoroutineScope(IO).launch {
            metricDao.deleteAllScheduledMedication()
        }
    }
}