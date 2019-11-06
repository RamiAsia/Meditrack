package dev.ramiasia.meditrack

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NewPillActivity : AppCompatActivity() {

    lateinit var editPillView : EditText
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pill)
        init()
    }

    fun init() {
        editPillView = findViewById(R.id.edit_pill)
        saveButton = findViewById(R.id.button_save)
        saveButton.setOnClickListener {
            println("Pressed save! Text filled: ${editPillView.text.isNotEmpty()}")
            if (editPillView.text.isNotEmpty()) {
                val replyIntent = Intent()
                replyIntent.putExtra(EXTRA_REPLY, editPillView.text.toString())
                setResult(Activity.RESULT_OK, replyIntent)
                finish()
            }
        }
    }

    companion object {
        val EXTRA_REPLY = "com.example.android.roompillssample.REPLY";
    }
}
