package dev.ramiasia.meditrack.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ramiasia.meditrack.data.entity.PillIngestion
import dev.ramiasia.meditrack.databinding.RecyclerViewPillBinding
import java.time.OffsetDateTime

class PillListAdapter(context: Context) : RecyclerView.Adapter<PillListAdapter.PillViewHolder>() {
    private val inflater : LayoutInflater = LayoutInflater.from(context)
    var pillIngestions: List<PillIngestion> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PillViewHolder {
        val recyclerViewPillBinding = RecyclerViewPillBinding.inflate(inflater, parent, false)
        return PillViewHolder(recyclerViewPillBinding)
    }

    override fun onBindViewHolder(holder: PillViewHolder, position: Int) {
        if (pillIngestions.isNotEmpty()) {
            //TODO:Encapsulate data in POJO
            val pill = pillIngestions[position]
//            holder.pillItemView.text = pill.name
        }
    }

    override fun getItemCount(): Int {
        if (pillIngestions.isNullOrEmpty()) {
            return 0
        }
        return pillIngestions.size
    }


    class PillViewHolder(val binding: RecyclerViewPillBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(map: Map<OffsetDateTime, List<PillIngestion>>, pillIngestion: PillIngestion) {
            binding.pillName = pillIngestion.name
            binding.map = map
        }
    }
}