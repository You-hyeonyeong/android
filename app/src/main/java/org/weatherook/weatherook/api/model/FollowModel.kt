package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class FollowModel(
        @SerializedName("message") val message: String, // User follower ID success
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("showFollowerIDResult") val showFollowerIDResult: List<ShowFollowerIDResult>
    ) {

        data class ShowFollowerIDResult(
                @SerializedName("user_id") val userId: String, // minority78
                @SerializedName("user_img") val userImg: Any, // null
                @SerializedName("user_desc") val userDesc: Any // null
        )
    }
}