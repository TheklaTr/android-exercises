package hien.t.showgolfcoursesinmap

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker


class CustomInfoWindowAdapter(context : Context) : GoogleMap.InfoWindowAdapter {
    private val mWindow : View
    private val mContext : Context

    init{
        mContext = context
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null)
    }

    private fun rendowWindowText(marker : Marker, view : View) {
        val title = marker.title
        val tvTitle : TextView = view.findViewById(R.id.title)
        if (title != "") tvTitle.text = title

        val snippet = marker.snippet
        val tvSnippet : TextView = view.findViewById(R.id.snippet)
        if (snippet != "") tvSnippet.text = snippet
    }

    override fun getInfoWindow(marker : Marker):View {
        rendowWindowText(marker, mWindow)
        return mWindow
    }

    override fun getInfoContents(marker : Marker):View {
        rendowWindowText(marker, mWindow)
        return mWindow
    }
}