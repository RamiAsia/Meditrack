package dev.ramiasia.meditrack.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.ramiasia.meditrack.data.entity.PillIngestion
import dev.ramiasia.meditrack.repo.PillRepository

class PillViewModel(application: Application) : AndroidViewModel(application) {

    private var pillRepository = PillRepository(application)
    var pills = pillRepository.pills
        private set

    fun insert(pillIngestion: PillIngestion) {
        pillRepository.insert(pillIngestion)
    }
}