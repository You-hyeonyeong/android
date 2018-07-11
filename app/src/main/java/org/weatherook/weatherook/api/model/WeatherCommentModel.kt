package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class WeatherCommentModel(
        @SerializedName("message") val message: String, // Successfully get One board
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("weather_text_temp") val weatherTextTemp: String, // 이 세상엔 사랑으로 감싸줘야 사람들이 생각보다 많아요.
            @SerializedName("weather_text_weather") val weatherTextWeather: String // 이렇게 날도 좋은 날에 작은 사랑 실천해보는건 어때요?
    )
}