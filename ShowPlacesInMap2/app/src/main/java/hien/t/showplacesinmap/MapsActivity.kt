package hien.t.showplacesinmap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener  {

    override fun onMarkerClick(marker: Marker?): Boolean {
        Toast.makeText(this,marker!!.title, Toast.LENGTH_LONG).show()
        return true
    }

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
        val url = "https://api.myjson.com/bins/9bkhb"
        // Create request and listeners
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                // Get places from JSON
                val places = response.getJSONArray("places")
                for (i in 0 .. (places.length() - 1)) {
                    val place = places.getJSONObject(i)
                    val placeName = place.getString("placeName")
                    val lat = place.getString("latitude").toDouble()
                    val lng = place.getString("longitude").toDouble()
                    val positions = LatLng(lat, lng)
                    mMap.addMarker(MarkerOptions().position(positions).title(placeName))
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(61.8178084, 25.2322629), 5.0F))
                    // zoom
                    mMap.uiSettings.isZoomControlsEnabled = true
                    // click listener
                    mMap.setOnMarkerClickListener(this)
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
