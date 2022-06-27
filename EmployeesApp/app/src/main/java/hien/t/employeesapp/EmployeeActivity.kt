package hien.t.employeesapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_employee.*
import org.json.JSONObject

class EmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        // get data from intent
        val bundle : Bundle? = intent.extras
        if (bundle != null) {
            val employeeString = bundle!!.getString("employee")
            val employee = JSONObject(employeeString)
            val name = employee["firstName"]
            Toast.makeText(this, "Name is $name",Toast.LENGTH_LONG).show()

            nameTextView.text = nameTextView.context.getString(R.string.fullname_text, employee["lastName"].toString(), employee["firstName"].toString())
            titleTextView.text = employee["title"].toString()
            phoneTextView.text = employee["phone"].toString()
            emailTextView.text = employee["email"].toString()
            departmentTextView.text = employee["department"].toString()
            infoTextView.text = getString(R.string.info_text)
            Glide.with(employeeView.context).load(getString(R.string.image_url, employee["image"].toString())).into(employeeView)
        }
    }
}
