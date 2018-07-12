package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class UserSettingModel(
        @SerializedName("message") val message: String, // user show success
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("showUserResult") val showUserResult: List<ShowUserResult>,
            @SerializedName("style") val style: List<Any>
    ) {

        data class ShowUserResult(
                @SerializedName("user_img") val userImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531417006706.png
                @SerializedName("user_id") val userId: String, // awesome33
                @SerializedName("user_gender") val userGender: String, // 남
                @SerializedName("user_desc") val userDesc: String, // 종끄부끄부끄
                @SerializedName("user_age") val userAge: Int, // 22
                @SerializedName("user_height") val userHeight: Int, // 170
                @SerializedName("user_weight") val userWeight: Int // 70
        )
    }
}