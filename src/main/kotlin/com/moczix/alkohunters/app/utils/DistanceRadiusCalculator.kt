package com.moczix.alkohunters.app.utils

class RadiusSquareCalculator constructor(distance: Int = 10, lat: Double = 0.0, lng: Double = 0.0) {
    private val earthRadius: Double = 6371.0

    var maxLat: Double = 0.0
    var minLat: Double = 0.0
    var maxLng: Double = 0.0
    var minLng: Double = 0.0


    init {
        maxLat = lat + Math.toDegrees(distance / earthRadius)
        minLat = lat - Math.toDegrees(distance / earthRadius)
        maxLng = lng + Math.toDegrees(distance / earthRadius / Math.cos(Math.toRadians(lat)))
        minLng = lng - Math.toDegrees(distance / earthRadius / Math.cos(Math.toRadians(lat)))
    }

}