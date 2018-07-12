package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class WeatherModel(
        @SerializedName("message") val message: String, // successfully get weather
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("date_type") val dateType: Int, // 1
            @SerializedName("current_weather") val currentWeather: Int, // 1
            @SerializedName("current_temp") val currentTemp: Int, // 29
            @SerializedName("current_pop") val currentPop: Int, // 10
            @SerializedName("current_reh") val currentReh: Int, // 75
            @SerializedName("temp_af") val tempAf: Int, // 23
            @SerializedName("temp_am") val tempAm: Int, // 30
            @SerializedName("weather_af") val weatherAf: String, // 구름 많음
            @SerializedName("weather_am") val weatherAm: String // 구름 조금
    )
}