package hien.t.adaptiveuiexercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img : ImageView = findViewById(R.id.imageView)
        img.setOnClickListener { view ->
            Toast.makeText(this, "Image clicked!", Toast.LENGTH_LONG).show()
        }

        infoTextView.text = getString(R.string.imageInfo_txt)
    }
}
