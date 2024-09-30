package ru.mobui.mad.layout

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.mobui.mad.layout.databinding.ActivityRelativeLayoutBinding

class RelativeLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRelativeLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val view = buildView() // Программное создание макета
        //val view = binding.root  // Макет из XML разметки
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun buildView(): View {
        val view = RelativeLayout(this).apply{
            layoutParams = RelativeLayout.LayoutParams(
                MATCH_PARENT,
                MATCH_PARENT,
            )
        }


        val center = Button(this).apply {
            id = R.id.centerButton
            text = resources.getText(R.string.center)
            layoutParams = RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                addRule(RelativeLayout.CENTER_IN_PARENT)
            }
        }


        val vertical = View(this).apply {
            id = R.id.topButton
            background = ResourcesCompat.getDrawable(resources,android.R.color.holo_purple, theme)
            layoutParams = RelativeLayout.LayoutParams(24.dp, 150.dp).apply {
                setMargins(0.dp,0.dp,0.dp,16.dp)
                addRule(RelativeLayout.ABOVE, R.id.centerButton)
                addRule(RelativeLayout.CENTER_HORIZONTAL)
            }
        }

        view.addView(center)
        view.addView(vertical)

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