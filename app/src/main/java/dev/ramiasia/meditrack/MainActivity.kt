package dev.ramiasia.meditrack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.ramiasia.meditrack.data.entity.PillIngestion
import dev.ramiasia.meditrack.ui.CardListAdapter
import dev.ramiasia.meditrack.viewmodel.PillViewModel
import java.time.OffsetDateTime


class MainActivity : AppCompatActivity() {

    private lateinit var cardRecyclerView: RecyclerView
    private lateinit var pillRecyclerView: RecyclerView
    private lateinit var cardListAdapter: CardListAdapter
    private lateinit var pillListAdapter: CardListAdapter
    private lateinit var cardViewModel: PillViewModel
    private lateinit var pillViewModel: PillViewModel
    private lateinit var pillFab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        cardRecyclerView = findViewById(R.id.cardRecyclerView)
        cardListAdapter = CardListAdapter(this)
        cardRecyclerView.adapter = cardListAdapter
        cardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cardViewModel = ViewModelProviders.of(this).get(PillViewModel::class.java)
        cardViewModel.pills.observe(this, Observer<List<PillIngestion>> {
            cardListAdapter.pillIngestions = it
        })
        pillFab = findViewById(R.id.floatingActionButton)
        pillFab.setOnClickListener {
            val intent = Intent(this, NewPillActivity::class.java)
            startActivityForResult(intent, NEW_PILL_ACTIVITY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println("Request code is $requestCode and result is $resultCode")
        if (requestCode == NEW_PILL_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            val pill = PillIngestion(
                name = data?.getStringExtra(NewPillActivity.EXTRA_REPLY),
                time = OffsetDateTime.now(),
                taken = true
            )
            cardViewModel.insert(pill)
            println("Inserted pill")
        }
    }

    companion object {
        const val NEW_PILL_ACTIVITY_REQUEST_CODE = 1
    }
}
