package dev.ramiasia.meditrack.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ramiasia.meditrack.R
import dev.ramiasia.meditrack.data.entity.Pill
import android.view.ViewGroup



class PillListAdapter(context: Context) : RecyclerView.Adapter<PillListAdapter.PillViewHolder>() {

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    var pills : List<Pill> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PillViewHolder {
        val pillView = inflater.inflate(R.layout.recyclerview_pill, parent, false)
        return PillViewHolder(pillView)
    }

    override fun onBindViewHolder(holder: PillViewHolder, position: Int) {
        if (pills.isNullOrEmpty()) {
            holder.pillItemView.text = "No pills taken"
        } else {
            var pill = pills[position]
            holder.pillItemView.text = pill.name
        }
    }

    override fun getItemCount(): Int {
        if (pills.isNullOrEmpty()) {
            return 0
        }
        return pills.size
    }


    class PillViewHolder(pillView: View) : RecyclerView.ViewHolder(pillView) {
        val pillItemView : TextView = pillView.findViewById(R.id.textView)
    }
}