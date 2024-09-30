package ru.mobui.mad.layout

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.allViews
import androidx.core.view.setMargins
import ru.mobui.mad.layout.databinding.ActivityFrameLayoutBinding

class FrameLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFrameLayoutBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)

        //val view = buildView() // Программное создание макета
        val view = binding.root  // Макет из XML разметки
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun buildView(): View
    {
        val view = FrameLayout(this).apply {
            layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            id = R.id.main
        }

        val textViewRed = TextView(this).apply {
            layoutParams = FrameLayout.LayoutParams(200.dp,100.dp).apply {
                gravity = Gravity.START or Gravity.TOP
                setMargins(16.dp)
            }
            text = resources.getText(R.string.left_top)
            textSize = 22f
            setBackgroundColor(resources.getColor(android.R.color.holo_red_dark, theme))
            setTextColor(resources.getColor(android.R.color.white, theme))
            gravity = Gravity.CENTER
        }

        val textViewOrange = TextView(this).apply {
            layoutParams = FrameLayout.LayoutParams(200.dp,100.dp).apply {
                gravity = Gravity.CENTER
                setMargins(16.dp)
            }
            text = resources.getText(R.string.center)
            textSize = 22f
            setBackgroundColor(resources.getColor(android.R.color.holo_orange_dark, theme))
            setTextColor(resources.getColor(android.R.color.white, theme))
            gravity = Gravity.CENTER
        }


        val textViewGreen = TextView(this).apply {
            layoutParams = FrameLayout.LayoutParams(200.dp,100.dp).apply {
                gravity = Gravity.END or Gravity.BOTTOM
                setMargins(16.dp)
            }
            text = resources.getText(R.string.right_bottom)
            textSize = 22f
            setBackgroundColor(resources.getColor(android.R.color.holo_green_dark, theme))
            setTextColor(resources.getColor(android.R.color.white, theme))
            gravity = Gravity.CENTER
        }
        view.addView(textViewRed)
        view.addView(textViewOrange)
        view.addView(textViewGreen)
        return view
    }

    val Int.dp  get(): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        resources.displayMetrics).toInt()

    val Float.dp  get(): Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        resources.displayMetrics)

    val Int.sp  get(): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        resources.displayMetrics).toInt()

    val Float.sp  get(): Float = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this,
        resources.displayMetrics)
}