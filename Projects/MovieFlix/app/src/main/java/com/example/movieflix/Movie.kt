package com.example.movieflix
import com.google.gson.annotations.SerializedName

/**
 * SerializedName tag to match the JSON response
 * for an object to correctly parse with gson library.
 */
class Movie {

    //@JvmField
    @SerializedName("title")
    var title: String? = ""

    // @JvmField
    @SerializedName("overview")
    var summary: String? = ""

    @JvmField
    @SerializedName("poster_path")
    var imageUrl: String? = null

}