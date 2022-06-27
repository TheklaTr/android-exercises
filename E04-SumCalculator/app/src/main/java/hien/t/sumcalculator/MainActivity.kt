
package hien.t.sumcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var number1 = number1EditText.text
        var number2 = number2EditText.text

        button.setOnClickListener {
            var result = number1.toString().toLong() + number2.toString().toLong()
            var sumText = "$number1 + $number2 = $result"
            Toast.makeText(this, sumText, Toast.LENGTH_LONG).show()
        }
    }
}
