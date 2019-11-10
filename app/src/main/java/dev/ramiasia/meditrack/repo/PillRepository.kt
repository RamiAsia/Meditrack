package dev.ramiasia.meditrack.repo

import android.app.Application
import androidx.lifecycle.LiveData
import dev.ramiasia.meditrack.data.MeditrackRoomDatabase
import dev.ramiasia.meditrack.data.MetricDao
import dev.ramiasia.meditrack.data.entity.PillIngestion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class PillRepository(application: Application) {

    private var db : MeditrackRoomDatabase = MeditrackRoomDatabase.invoke(application)
    private var pillDao: MetricDao = db.metricDao()
    var pills: LiveData<List<PillIngestion>> = pillDao.getAllIngestions()
        private set

    fun insert(pillIngestion: PillIngestion) {
       CoroutineScope(IO).launch {
           pillDao.insert(pillIngestion)
        }
    }

}