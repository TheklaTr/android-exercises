package hientr.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(view: View) {
        // activity_main layout has textView id in TextView element
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.setText(R.string.button_clicked_txt);
    }

}

