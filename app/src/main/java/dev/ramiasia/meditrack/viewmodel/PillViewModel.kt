package dev.ramiasia.meditrack.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.ramiasia.meditrack.data.entity.Pill
import dev.ramiasia.meditrack.repo.PillRepository

class PillViewModel(application: Application) : AndroidViewModel(application) {

    private var pillRepository = PillRepository(application)
    var pills = pillRepository.pills
        private set

    fun insert(pill: Pill) {
        pillRepository.insert(pill)
    }
}