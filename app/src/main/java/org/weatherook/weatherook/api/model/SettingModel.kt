package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class SettingModel(
        @SerializedName("message") val message: String, // Successfully user Updated
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("user_idx") val userIdx: Int, // 1
            @SerializedName("user_gender") val userGender: String // 남
    )
}