package ru.mobui.mad.uicomponent

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.mobui.mad.uicomponent.databinding.ActivityImageViewBinding

class ImageViewActivity : AppCompatActivity() {
    private lateinit var binding:ActivityImageViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        binding.bnFitXY.setOnClickListener {
            binding.image.scaleType = ImageView.ScaleType.FIT_XY
        }
        binding.bnCenterCrop.setOnClickListener {
            binding.image.scaleType = ImageView.ScaleType.CENTER_CROP
        }
        binding.bnCenterInside.setOnClickListener {
            binding.image.scaleType = ImageView.ScaleType.CENTER_INSIDE
        }
    }
}