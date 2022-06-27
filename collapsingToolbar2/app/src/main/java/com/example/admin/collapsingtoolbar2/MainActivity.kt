package com.example.admin.collapsingtoolbar2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.support.v7.view.CollapsibleActionView

class MainActivity : AppCompatActivity() {
    private var collapsingToolbarLayout: CollapsingToolbarLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout
        collapsingToolbarLayout!!.title = "Collapsing Toolbar"

        dynamicColor()
    }

    private fun dynamicColor() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.nature_one)
        Palette.from(bitmap).generate { palette ->
            collapsingToolbarLayout!!.setContentScrimColor(palette.getMutedColor(resources.getColor(R.color.colorPrimary)))
            collapsingToolbarLayout!!.setStatusBarScrimColor(palette.getMutedColor(resources.getColor(R.color.colorAccent)))
        }
    }


}
