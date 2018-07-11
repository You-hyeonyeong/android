package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class BoardModel(
        @SerializedName("message") val message: String, // show Personal Board Img success
        @SerializedName("data") val data: Data
) {

    data class Data(
            @SerializedName("showUserPageResult") val showUserPageResult: List<ShowUserPageResult>,
            @SerializedName("showBoardNumResult") val showBoardNumResult: List<ShowBoardNumResult>,
            @SerializedName("showFollowerNumResult") val showFollowerNumResult: List<ShowFollowerNumResult>,
            @SerializedName("showFollogingNumResult") val showFollogingNumResult: List<ShowFollogingNumResult>,
            @SerializedName("showBoardAllResult") val showBoardAllResult: List<ShowBoardAllResult>,
            @SerializedName("showBoardCommentResult") val showBoardCommentResult: List<Any>
    ) {

        data class ShowUserPageResult(
                @SerializedName("user_img") val userImg: Any, // null
                @SerializedName("user_id") val userId: String, // awesome33
                @SerializedName("user_desc") val userDesc: Any // null
        )


        data class ShowBoardNumResult(
                @SerializedName("board_num") val boardNum: Int // 3
        )


        data class ShowFollogingNumResult(
                @SerializedName("following") val following: Int // 9
        )


        data class ShowBoardAllResult(
                @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531061851244.PNG
                @SerializedName("board_desc") val boardDesc: String, // 날씨가 좋아져서 다행이다
                @SerializedName("board_date") val boardDate: String, // 2018-07-07T14:57:31.000Z
                @SerializedName("board_weather") val boardWeather: Int, // 0
                @SerializedName("board_temp_min") val boardTempMin: Int, // 15
                @SerializedName("board_temp_max") val boardTempMax: Int // 22
        )


        data class ShowFollowerNumResult(
                @SerializedName("follower") val follwer: Any // 5
        )
    }
}