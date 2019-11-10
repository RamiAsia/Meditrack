package dev.ramiasia.meditrack.repo

import android.app.Application
import androidx.lifecycle.LiveData
import dev.ramiasia.meditrack.data.MeditrackRoomDatabase
import dev.ramiasia.meditrack.data.MetricDao
import dev.ramiasia.meditrack.data.entity.ScheduledPill
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class PillRepository(application: Application) {

    private var db : MeditrackRoomDatabase = MeditrackRoomDatabase.invoke(application)
    private var pillDao: MetricDao = db.metricDao()
    var pills : LiveData<List<ScheduledPill>> = pillDao.getAllPills()
        private set

    fun insert(scheduledPill: ScheduledPill) {
       CoroutineScope(IO).launch {
            pillDao.insert(scheduledPill)
        }
    }

}