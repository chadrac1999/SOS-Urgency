package com.example.hsamuel.urgency.maps

import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.widget.Toast
import com.example.hsamuel.urgency.R
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import java.io.IOException

class MapsActivity : FragmentActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener, PlaceSelectionListener {


    //implementation of GoogleMap.OnMarkerClickListener interface methods

    override fun onMarkerClick(p0: Marker?): Boolean = false

    private var map: GoogleMap? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location

    private lateinit var locationCallback: LocationCallback

    private lateinit var locationRequest: LocationRequest
    private var locationUpdateState = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)




        fab.setOnClickListener { view ->
            val autocompleteFragment = fragmentManager.findFragmentById(R.id.place_autocomplete_fragment)
                    as PlaceAutocompleteFragment
            autocompleteFragment.setOnPlaceSelectedListener(this)

            val typeFilter = AutocompleteFilter.Builder()
                    .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS)
                    .build()
            val intent = PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                    .setFilter(typeFilter)
                    .build(this)

            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE)
        }


    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        map!!.getUiSettings().setZoomControlsEnabled(true)
        map!!.setOnMarkerClickListener(this)


        setUpMap()
    }


    //The code above checks if the app has been granted the ACCESS_FINE_LOCATION permission.
        private fun setUpMap() {

             if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
            }

        // isMyLocationEnabled = true enables the my-location layer which draws a light blue dot on the user’s location.
        // It also adds a button to the map that, when tapped, centers the map on the user’s location.
        map!!.isMyLocationEnabled = true
        map!!.mapType = GoogleMap.MAP_TYPE_TERRAIN

        //fusedLocationClient.getLastLocation() gives the most recent location currently available.

        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(currentLatLng)
                map!!.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
                }
            }
        }
        private fun placeMarkerOnMap(location: LatLng) {
        // Create a MarkerOptions object and sets the user’s
        // current location as the position for the marker
        val markerOptions = MarkerOptions().position(location)

            //Here I added a call to getAddress() and added this address as the marker title.

            val titleStr = getAddress(location)  // add these two lines
            markerOptions.title(titleStr)

        // Add the marker to the map
        map!!.addMarker(markerOptions)
        }


    private fun getAddress(latLng: LatLng): String {
        //The Geocoder object turn a latitude and longitude coordinate into an address and vice versa.
        val geocoder = Geocoder(this)
        val addresses: List<Address>?
        val address: Address?
        var addressText = ""

        try {
            // Asks the geocoder to get the address from the location passed to the method.
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)

            // If the response contains any address, then append it to a string and return.
            if (null != addresses && !addresses.isEmpty()) {
                address = addresses[0]
                for (i in 0 until address.maxAddressLineIndex) {
                    addressText += if (i == 0) address.getAddressLine(i) else "\n" + address.getAddressLine(i)
                }
            }
        } catch (e: IOException) {
            Log.e("MapsActivity", e.localizedMessage)
        }
        return addressText
    }
    override fun onPlaceSelected(place: Place?) {

        Toast.makeText(applicationContext,""+place!!.name+place.latLng,Toast.LENGTH_LONG).show()

    }

    override fun onError(status: Status?) {
        Toast.makeText(applicationContext,""+status.toString(),Toast.LENGTH_LONG).show()

    }


    companion object {

        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
        private const val PLACE_AUTOCOMPLETE_REQUEST_CODE = 2



    }

}
