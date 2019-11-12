package dev.ramiasia.meditrack.util

import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import dev.ramiasia.meditrack.R
import dev.ramiasia.meditrack.data.entity.PillIngestion
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class BindingAdapters {
    companion object {

        @BindingAdapter("app:inflatePills")
        fun inflatePills(layout: LinearLayout, data: Map<OffsetDateTime, List<PillIngestion>>) {
            for ((time, pills) in data) {
                val timeText = TextView(layout.context)
                timeText.text = time.format(DateTimeFormatter.ofPattern("h:m"))
                timeText.setPadding(0, 10, 0, 0)
                layout.addView(timeText)
                val horizontalScrollView = HorizontalScrollView(layout.context)
                for (pill in pills) {
                    val imageView = ImageView(layout.context)
                    imageView.setImageResource(if (pill.taken) R.drawable.ic_pill_taken else R.drawable.ic_pill_not_taken)
                    horizontalScrollView.addView(imageView)
                }
                layout.addView(horizontalScrollView)
            }
        }
    }
}