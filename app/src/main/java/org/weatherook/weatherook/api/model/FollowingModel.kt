package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class FollowingModel(
        @SerializedName("message") val message: Any, // User Following ID success
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("showFollowingIDResult") val showFollowingIDResult: List<ShowFollowingIDResult>
    ) {

        data class ShowFollowingIDResult(
                @SerializedName("user_id") val userId: String, // mina_3
                @SerializedName("user_img") val userImg: String, // null
                @SerializedName("user_desc") val userDesc: Any // null
        )
    }
}