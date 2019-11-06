package dev.ramiasia.meditrack.repo

import android.app.Application
import androidx.lifecycle.LiveData
import dev.ramiasia.meditrack.data.MeditrackRoomDatabase
import dev.ramiasia.meditrack.data.PillDao
import dev.ramiasia.meditrack.data.entity.Pill
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class PillRepository(application: Application) {

    private var db : MeditrackRoomDatabase = MeditrackRoomDatabase.invoke(application)
    private var pillDao: PillDao = db.pillDao()
    var pills : LiveData<List<Pill>> = pillDao.getAllPills()
        private set

    fun insert(pill: Pill) {
       CoroutineScope(IO).launch {
            pillDao.insert(pill)
        }
    }

}