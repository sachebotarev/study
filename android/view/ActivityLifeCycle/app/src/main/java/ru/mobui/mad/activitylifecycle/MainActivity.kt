package ru.mobui.mad.activitylifecycle

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.mobui.mad.activitylifecycle.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private val TAG = "MAIN_ACTIVITY"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate, savedInstanceState = $savedInstanceState")

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.newActivity.setOnClickListener {
            startActivity(Intent(this,NewActivity::class.java))
        }

        binding.newTransparentActivity.setOnClickListener {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
//            AlertDialog.Builder(this)
//                .setTitle("Hello")
//                .setMessage("This is alert dialog")
//                .setIcon(R.drawable.ic_dialog_alert).show()
        }

        binding.minimizeTheApp.setOnClickListener {
            moveTaskToBack(true)
        }
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState, outState = $outState")
        super.onSaveInstanceState(outState)
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}
