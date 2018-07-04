package org.weatherook.weatherook.adapter

class GalleryEventbus internal constructor(uri: String) {

    var uri: String
        internal set

    init {
        this.uri = uri
    }

    fun getImageUri(): String {
        return uri
    }
}