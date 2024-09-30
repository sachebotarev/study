package ru.mobui.mad.saveinstancestate

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.mobui.mad.saveinstancestate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val tag = "MAIN_ACTIVITY"
    private lateinit var binding: ActivityMainBinding
    private lateinit var value:Counter
    private val keyValue = "value"
    override fun onCreate(savedInstanceState: Bundle?) {
        value = savedInstanceState?.getParcelable<Counter>(keyValue) ?: Counter(0)
        Log.i(tag, "onCreate: counter = ${value.counter} ,savedInstanceState = $savedInstanceState ")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textView.text = value.counter.toString()

        binding.button.setOnClickListener {
            value = Counter(value.counter + 1)
            binding.textView.text = value.counter.toString()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i(tag, "onRestoreInstanceState: counter = $value")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onResume() {
        Log.i(tag, "onResume: counter = $value")
        super.onResume()
    }

    override fun onStart() {
        Log.i(tag, "onStart: counter = $value")
        super.onStart()
    }

    override fun onStop() {
        Log.i(tag, "onStop: counter = $value")
        super.onStop()
    }

    override fun onPause() {
        Log.i(tag, "onPause: counter = $value")
        super.onPause()
    }

    override fun onDestroy() {
        Log.i(tag, "onDestroy: counter = $value")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(keyValue,value)
        super.onSaveInstanceState(outState)

    }
}

class Counter(val  counter: Int) :  Parcelable {
    constructor(parcel: Parcel) : this(counter = parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(counter)
    }

    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<Counter> {
        override fun createFromParcel(parcel: Parcel): Counter {
            return Counter(parcel)
        }

        override fun newArray(size: Int): Array<Counter?> {
            return arrayOfNulls(size)
        }
    }
}