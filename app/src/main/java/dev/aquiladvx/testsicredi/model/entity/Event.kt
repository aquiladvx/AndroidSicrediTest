package dev.aquiladvx.testsicredi.model.entity
import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("date")
    val date: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("people")
    val people: List<String>,
    @SerializedName("price")
    val price: Double,
    @SerializedName("title")
    val title: String
)