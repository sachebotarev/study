package ru.mobui.mad.layout

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.mobui.mad.layout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.bnFrameLayout.setOnClickListener {
            startActivity(Intent(this@MainActivity ,FrameLayoutActivity::class.java))
        }
        binding.bnLinearLayout.setOnClickListener {
            startActivity(Intent(this@MainActivity ,LinearLayoutActivity::class.java))
        }

        binding.bnRelativeLayout.setOnClickListener {
            startActivity(Intent(this@MainActivity ,RelativeLayoutActivity::class.java))
        }
    }
}