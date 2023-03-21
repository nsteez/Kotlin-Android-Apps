package com.example.movieflix
import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Keep
@Serializable
data class Actor (
    @SerializedName("name")
    var name: String?,

    @SerializedName("profile_path")
    var imageUrl: String?,

    @SerializedName("popularity")
    val popularity: String?,

    @SerializedName("known_for")
    var known: List<Known>
) : java.io.Serializable


@Keep
@Serializable
data class Known(
//    @SerializedName("popularity")
//    val popularity: String?,
//
    @SerializedName("original_title")
    var title: String?,

    @SerializedName("overview")
    var overview: String?
) : java.io.Serializable
