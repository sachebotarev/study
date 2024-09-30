package ru.mobui.mad.uicomponent

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import ru.mobui.mad.uicomponent.databinding.ActivityCheckBoxBinding

class CheckBoxActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.checkboxMeat.setOnCheckedChangeListener { buttonView, isChecked ->
            Log.d("CHECKBOXES", "Meat is checked: $isChecked")
            val text = if (isChecked) "Check meet" else  "Uncheck meet"
            Snackbar.make(binding.checkboxMeat, text, Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

        binding.checkboxCheese
            .setOnCheckedChangeListener { buttonView, isChecked ->
                Log.d("CHECKBOXES", "Cheese is checked: $isChecked")
                val text = if (isChecked) "Check cheese" else  "Uncheck cheese"
                Snackbar.make(binding.checkboxCheese, text , Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
            }
    }
}