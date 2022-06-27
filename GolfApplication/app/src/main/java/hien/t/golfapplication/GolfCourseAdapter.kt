package hien.t.golfapplication

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.golf_course_item.view.*
import org.json.JSONArray
import org.json.JSONObject

class GolfCourseAdapter(private val courses: JSONArray) : RecyclerView.Adapter<GolfCourseAdapter.ViewHolder>() {

    // create UI View Holder from XML layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GolfCourseAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.golf_course_item, parent, false)
        return ViewHolder(view)
    }

    // return item count in employees
    override fun getItemCount(): Int = courses.length()

    // bind data to UI View Holder
    override fun onBindViewHolder(holder: GolfCourseAdapter.ViewHolder, position: Int) {
        // employee to bind UI
        val course: JSONObject = courses.getJSONObject(position)
        // name
        holder.courseTextView.text = course["course"].toString()
        // address
        holder.addressTextView.text = course["address"].toString()
        // email
        holder.emailTextView.text = course["email"].toString()
        // phone
        holder.phoneTextView.text = course["phone"].toString()

        // to get context in Glide, you can use holder.imageView.context
        Glide.with(holder.imageView.context).load("http://ptm.fi/materials/golfcourses/" + course["image"].toString()).into(holder.imageView)
    }

    // View Holder class to hold UI views
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val courseTextView: TextView = view.courseTextView
        // add other Views here too
        val addressTextView : TextView = view.addressTextView
        val emailTextView : TextView = view.emailTextView
        val phoneTextView : TextView = view.phoneTextView
        val imageView : ImageView = view.imageView


        // add a item click listener
        init {
            itemView.setOnClickListener {
                // create an explicit intent
                val intent = Intent(view.context, GolfCourseActivity::class.java)
                // add selected employee json as a string data
                intent.putExtra("course", courses[adapterPosition].toString())
                // start a new activity
                view.context.startActivity(intent)
            }
        }
    }
}