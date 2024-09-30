package ru.mobui.mad.uicomponent

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import ru.mobui.mad.uicomponent.databinding.ActivitySwitchBinding

class SwitchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySwitchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySwitchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        
        binding.materialSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            Log.d("SWITCH", "Switch is checked: $isChecked")
            val text = if (isChecked) "Is checked" else  "Is unchecked"
            Snackbar.make(binding.materialSwitch, text , Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
         }

        binding.toggle.setOnCheckedChangeListener { buttonView, isChecked ->
            Log.d("TOGGLE", "Toggle is checked: $isChecked")
            val text = if (isChecked) "Toggle on" else  "Toggle off"
            Snackbar.make(binding.materialSwitch, text , Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }
}