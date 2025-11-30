package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.maplibre.android.MapLibre
import org.maplibre.android.WellKnownTileServer

class MainActivity : AppCompatActivity() {

    private lateinit var mapController: MapController
    private lateinit var uiController: UiController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialize MapLibre (only required once, before creating MapView)
        MapLibre.getInstance(this, "VpgyO2ogB4DeaiIKkKXE", WellKnownTileServer.MapTiler)

        setContentView(R.layout.activity_main)

        // create controllers
        mapController = MapController(this, findViewById(R.id.mapView))
        uiController = UiController(this)

        // wire map ready callback
        mapController.init {
            // called when style & layers are ready
            // Example: center on a single location
            mapController.setSingleLocation(40.6444, -8.6487, 0f)

            // Example: optionally start a small route simulation
            mapController.simulateRoute(listOf(
                Pair(40.64325, -8.64680),
                Pair(40.64330, -8.64670),
                Pair(40.64335, -8.64660),
                Pair(40.64340, -8.64650),
                Pair(40.64345, -8.64640),
                Pair(40.64350, -8.64630),
                Pair(40.64355, -8.64620),
                Pair(40.64360, -8.64610),
                Pair(40.64365, -8.64600),
                Pair(40.64370, -8.64590),
                Pair(40.64375, -8.64580),
                Pair(40.64380, -8.64570),
                Pair(40.64385, -8.64560),
                Pair(40.64390, -8.64550),
                Pair(40.64395, -8.64540),
                Pair(40.64400, -8.64530),
                Pair(40.64405, -8.64520),
                Pair(40.64410, -8.64510),
                Pair(40.64415, -8.64500),
                Pair(40.64420, -8.64490)
            ))
        }
    }

    override fun onStart() {
        super.onStart()
        mapController.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapController.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapController.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapController.onStop()
    }

    override fun onDestroy() {
        mapController.onDestroy()
        super.onDestroy()
    }
}
