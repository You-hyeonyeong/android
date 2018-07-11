package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class FollowerModel(
        @SerializedName("message") val message: Any, // User follower ID success
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("showFollowerIDResult") val showFollowerIDResult: List<ShowFollowerIDResult>
    ) {

        data class ShowFollowerIDResult(
                @SerializedName("user_id") val userId: String, // minority78
                @SerializedName("user_img") val userImg: String, // null
                @SerializedName("user_desc") val userDesc: Any // null
        )
    }
}