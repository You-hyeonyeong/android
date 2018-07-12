package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName
import org.weatherook.weatherook.item.BoardCommentItem


data class FollowBoardModel(
        @SerializedName("message") val message: String, // Successfully today popular
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("board_idx") val boardIdx: Int, // 7
            @SerializedName("user_img") val userImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/younghyun.jpeg
            @SerializedName("user_id") val userId: String, // bulllean5
            @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531062236913.PNG
            @SerializedName("board_desc") val boardDesc: String, // Good morning.
            @SerializedName("like_cnt") val likeCnt: Int, // 1
            @SerializedName("board_temp_min") val boardTempMin: Int, // 15
            @SerializedName("board_temp_max") val boardTempMax: Int, // 21
            @SerializedName("board_weather") val boardWeather: Int, // 4
            @SerializedName("board_date") val boardDate: String, // 06-01
            @SerializedName("comment_list") val commentList: List<BoardCommentItem>,
            @SerializedName("comment_cnt") val commentCnt: Int, // 2
            @SerializedName("flag") val flag: Int // 0
    ) {

        /*data class Comment(
                @SerializedName("comment_idx") val commentIdx: Int, // 50
                @SerializedName("comment_desc") val commentDesc: String, // 멋져요
                @SerializedName("comment_date") val commentDate: String, // 2018-07-08T09:14:24.000Z
                @SerializedName("comment_id") val commentId: String // may_15
        )*/
    }
}