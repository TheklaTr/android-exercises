package hien.t.employeesapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.employee_item.view.*
import org.json.JSONArray
import org.json.JSONObject
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

// Employees Adapter, used in RecyclerView in MainActivity
class EmployeesAdapter(private val employees: JSONArray) : RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {

    // create UI View Holder from XML layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.employee_item, parent, false)
        return ViewHolder(view)
    }

    // return item count in employees
    override fun getItemCount(): Int = employees.length()

    // bind data to UI View Holder
    override fun onBindViewHolder(holder: EmployeesAdapter.ViewHolder, position: Int) {
        // employee to bind UI
        val employee: JSONObject = employees.getJSONObject(position)
        // name
        holder.nameTextView.text = holder.nameTextView.context.getString(
            R.string.fullname_text,
            employee["lastName"].toString(),
            employee["firstName"].toString())
        // title
        holder.titleTextView.text = holder.titleTextView.context.getString(
            R.string.title_text,
            employee["title"].toString())
        // email
        holder.emailTextView.text = holder.emailTextView.context.getString(
            R.string.email_text,
            employee["email"].toString())
        // phone
        holder.phoneTextView.text = holder.phoneTextView.context.getString(
            R.string.phone_text,
            employee["phone"].toString())
        // department
        holder.departmentTextView.text = holder.departmentTextView.context.getString(
            R.string.department_text,
            employee["department"].toString())

        // to get context in Glide, you can use holder.imageView.context
        Glide.with(holder.imageView.context).load(holder.imageView.context.getString(
            R.string.image_url,
            employee["image"].toString())).transform(RoundedCorners(150)).into(holder.imageView)
    }

    // View Holder class to hold UI views
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.nameTextView
        // add other Views here too
        val titleTextView : TextView = view.titleTextView
        val emailTextView : TextView = view.emailTextView
        val phoneTextView : TextView = view.phoneTextView
        val departmentTextView : TextView = view.departmentTextView
        val imageView : ImageView = view.employeeView

        // add a item click listener
        init {
            itemView.setOnClickListener {
                // create an explicit intent
                val intent = Intent(view.context, EmployeeActivity::class.java)
                // add selected employee json as a string data
                intent.putExtra("employee", employees[adapterPosition].toString())
                // start a new activity
                view.context.startActivity(intent)
            }
        }
    }
}