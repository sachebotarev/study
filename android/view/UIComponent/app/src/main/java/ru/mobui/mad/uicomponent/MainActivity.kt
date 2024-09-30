package ru.mobui.mad.uicomponent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.mobui.mad.uicomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bnTextView.setOnClickListener {
            startActivity(Intent(this,TextViewActivity::class.java))
        }
        binding.bnImageView.setOnClickListener {
            startActivity(Intent(this,ImageViewActivity::class.java))
        }
        binding.bnButton.setOnClickListener {
            startActivity(Intent(this,ButtonActivity::class.java))
        }
        binding.bnTextEdit.setOnClickListener {
            startActivity(Intent(this,TextEditActivity::class.java))
        }
        binding.bnCheckBox.setOnClickListener {
            startActivity(Intent(this,CheckBoxActivity::class.java))
        }
        binding.bnRadioButton.setOnClickListener {
            startActivity(Intent(this,RadioButtonActivity::class.java))
        }
        binding.bnSwitch.setOnClickListener {
            startActivity(Intent(this,SwitchActivity::class.java))
        }
        binding.bnFAB.setOnClickListener {
            startActivity(Intent(this,FloatActionButtonActivity::class.java))
        }
        binding.bnProgressBar.setOnClickListener {
            startActivity(Intent(this,ProgressBarActivity::class.java))
        }
    }
}