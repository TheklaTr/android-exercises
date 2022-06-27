package hien.t.golfapplication

import android.content.Intent
import android.content.pm.ResolveInfo
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_golfcourse.*
import org.json.JSONObject

class GolfCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_golfcourse)

        // get data from intent
        val bundle : Bundle? = intent.extras
        if (bundle != null) {
            val courseString = bundle!!.getString("course")
            val course = JSONObject(courseString)

            addressTextView.text = course["address"].toString()
            phoneTextView.text = course["phone"].toString()
            emailTextView.text = course["email"].toString()
            infoTextView.text = course["text"].toString()
            webTextView.text = course["web"].toString()
            webTextView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
            Glide.with(imageView.context).load("http://ptm.fi/materials/golfcourses/" + course["image"].toString()).into(imageView)
        }
    }

    // launch a map with implicit intent
    fun launchMap(v: View) {
        // get data from intent
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val courseString = bundle!!.getString("course")
            val course = JSONObject(courseString)

            val lat = course.getString("lat").toDouble()
            val lng = course.getString("lng").toDouble()

            // Build the intent
            val location = Uri.parse("geo:0,0?q=$lat,$lng")
            val mapIntent = Intent(Intent.ACTION_VIEW, location)
            mapIntent.setPackage("com.google.android.apps.maps")

            // Verify it resolves
            val activities: List<ResolveInfo> = packageManager.queryIntentActivities(mapIntent, 0)
            val isIntentSafe: Boolean = activities.isNotEmpty()

            // Start an activity if it's safe
            if (isIntentSafe && (mapIntent.resolveActivity(getPackageManager()) != null)) {
                startActivity(mapIntent)
            } else {
                Toast.makeText(this, "There is no activity to handle map intent!", Toast.LENGTH_LONG).show();
            }
        }
    }

    // open browser with implicit intent - show a chooser
    fun openBrowser(v: View) {
        // get data from intent
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val courseString = bundle!!.getString("course")
            val course = JSONObject(courseString)

            // Build the intent
            val web = Uri.parse(course["web"].toString())
            val webIntent = Intent(Intent.ACTION_VIEW, web)

            // Always use string resources for UI text.
            val title = resources.getString(R.string.web)
            // Create intent to show chooser
            val chooser = Intent.createChooser(webIntent, title)

            // Verify the intent will resolve to at least one activity
            if (webIntent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
        }
    }
}
