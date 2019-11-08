package dev.ramiasia.meditrack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ramiasia.meditrack.data.entity.Pill
import dev.ramiasia.meditrack.ui.PillListAdapter
import dev.ramiasia.meditrack.viewmodel.PillViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var pillListAdapter : PillListAdapter
    lateinit var pillViewModel: PillViewModel
    lateinit var pillFab : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        recyclerView = findViewById(R.id.recyclerview)
        pillListAdapter = PillListAdapter(this)
        recyclerView.adapter = pillListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        pillViewModel = ViewModelProviders.of(this).get(PillViewModel::class.java)
        pillViewModel.pills.observe(this, Observer<List<Pill>> {
            pillListAdapter.pills = it
        })
        pillFab = findViewById(R.id.floatingActionButton)
        pillFab.setOnClickListener {
            val intent = Intent(this, NewPillActivity::class.java)
            startActivityForResult(intent, NEW_PILL_ACTIVITY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println("Request code is ${requestCode} and result is ${resultCode}")
        if (requestCode == NEW_PILL_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            val pill = Pill(name = data?.getStringExtra(NewPillActivity.EXTRA_REPLY))
            pillViewModel.insert(pill)
            println("Inserted pill")
        }
    }

    companion object {
        const val NEW_PILL_ACTIVITY_REQUEST_CODE = 1
    }
}
