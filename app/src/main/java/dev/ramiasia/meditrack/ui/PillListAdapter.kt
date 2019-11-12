package dev.ramiasia.meditrack.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ramiasia.meditrack.R
import dev.ramiasia.meditrack.data.entity.PillIngestion


class PillListAdapter(context: Context) : RecyclerView.Adapter<PillListAdapter.PillViewHolder>() {

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    var pillIngestions: List<PillIngestion> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PillViewHolder {
        val pillView = inflater.inflate(R.layout.recycler_view_card, parent, false)
        return PillViewHolder(pillView)
    }

    override fun onBindViewHolder(holder: PillViewHolder, position: Int) {
        if (pillIngestions.isNotEmpty()) {
            val pill = pillIngestions[position]
            holder.pillItemView.text = pill.name
        }
    }

    override fun getItemCount(): Int {
        if (pillIngestions.isNullOrEmpty()) {
            return 0
        }
        return pillIngestions.size
    }


    class PillViewHolder(pillView: View) : RecyclerView.ViewHolder(pillView) {
        val pillItemView : TextView = pillView.findViewById(R.id.textView)
    }
}