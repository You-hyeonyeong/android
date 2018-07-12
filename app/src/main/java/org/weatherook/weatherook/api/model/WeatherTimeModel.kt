package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class WeatherTimeModel(
        @SerializedName("message") val message: String, // successfully get weather
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("hour") val hour: String, // 24
            @SerializedName("weather") val weather: Int, // 1
            @SerializedName("temp") val temp: Int // 24
    )
}