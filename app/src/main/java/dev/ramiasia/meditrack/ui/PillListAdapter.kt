package dev.ramiasia.meditrack.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ramiasia.meditrack.R
import dev.ramiasia.meditrack.data.entity.ScheduledPill
import android.view.ViewGroup



class PillListAdapter(context: Context) : RecyclerView.Adapter<PillListAdapter.PillViewHolder>() {

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    var scheduledPills : List<ScheduledPill> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PillViewHolder {
        val pillView = inflater.inflate(R.layout.recyclerview_pill, parent, false)
        return PillViewHolder(pillView)
    }

    override fun onBindViewHolder(holder: PillViewHolder, position: Int) {
        if (scheduledPills.isNullOrEmpty()) {
            holder.pillItemView.text = "No scheduledPills taken"
        } else {
            var pill = scheduledPills[position]
            holder.pillItemView.text = pill.name
        }
    }

    override fun getItemCount(): Int {
        if (scheduledPills.isNullOrEmpty()) {
            return 0
        }
        return scheduledPills.size
    }


    class PillViewHolder(pillView: View) : RecyclerView.ViewHolder(pillView) {
        val pillItemView : TextView = pillView.findViewById(R.id.textView)
    }
}