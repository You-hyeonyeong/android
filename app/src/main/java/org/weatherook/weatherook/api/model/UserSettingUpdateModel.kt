package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class UserSettingUpdateModel(
        @SerializedName("message") val message: String, // Successfully user Updated
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("showUserResult") val showUserResult: List<ShowUserResult>,
            @SerializedName("style") val style: List<String>
    ) {

        data class ShowUserResult(
                @SerializedName("user_img") val userImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/jonghyun.jpeg
                @SerializedName("user_id") val userId: String, // awesome33
                @SerializedName("user_desc") val userDesc: String, // Daily Look!
                @SerializedName("user_age") val userAge: Int, // 28
                @SerializedName("user_height") val userHeight: Int, // 168
                @SerializedName("user_weight") val userWeight: Int // 78
        )
    }
}