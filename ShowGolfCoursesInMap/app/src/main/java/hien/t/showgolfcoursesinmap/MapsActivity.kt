package hien.t.showgolfcoursesinmap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Instantiate the RequestQueue
        val queue = Volley.newRequestQueue(this)
        // URL to JSON data - remember use your own data here
        val url = "http://ptm.fi/materials/golfcourses/golf_courses.json"
        // Create request and listeners
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                // Get places from JSON

                val courses = response.getJSONArray("courses")
                // Create Custom InfoWindow Adapter with golf courses
                val customInfoWindow = CustomInfoWindowAdapter(this)

                for (i in 0 .. (courses.length() - 1)) {
                    val course = courses.getJSONObject(i)

                    val lat = course.getString("lat").toDouble()
                    val lng = course.getString("lng").toDouble()

                    val courseType = course.getString("type")
                    val courseName = course.getString("course")
                    val address = course.getString("address")
                    val phone = course.getString("phone")
                    val email = course.getString("email")
                    val webUrl = course.getString("web")
                    val snippets = address + "\n" +  phone + "\n" + email + "\n" + webUrl

                    mMap.setInfoWindowAdapter(customInfoWindow)

                    val options = MarkerOptions()
                    options
                        .position(LatLng(lat, lng))
                        .title(courseName)
                        .snippet(snippets)

                    if (courseType == "Kulta") {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                    }
                    else if (courseType == "Etu") {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))

                    }
                    else if (courseType == "Kulta/Etu") {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                    }
                    else
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    mMap.addMarker(options).showInfoWindow()


                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(61.0080962, 25.5519535), 7.0F))
                    // zoom

                    mMap.uiSettings.isZoomControlsEnabled = true
                }

            },
            Response.ErrorListener { error ->
                Log.d("JSON", error.toString())
            }
        )
        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }
}
