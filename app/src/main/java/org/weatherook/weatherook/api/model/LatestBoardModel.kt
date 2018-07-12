package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName
import org.weatherook.weatherook.item.BoardCommentItem


data class LatestBoardModel(
        @SerializedName("message") val message: String, // Successfully today latest
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("user_img") val userImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/siyun.jpeg
            @SerializedName("user_id") val userId: String, // blueberry3
            @SerializedName("board_idx") val boardIdx: Int, // 4
            @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531062031824.PNG
            @SerializedName("board_desc") val boardDesc: String, // 오랜만이얌
            @SerializedName("like_cnt") val likeCnt: Int, // 1
            @SerializedName("board_temp_min") val boardTempMin: Int, // 14
            @SerializedName("board_temp_max") val boardTempMax: Int, // 20
            @SerializedName("board_weather") val boardWeather: Int, // 0
            @SerializedName("board_date") val boardDate: String, // 07-01
            @SerializedName("comment_list") val commentList: List<BoardCommentItem>,
            @SerializedName("comment_cnt") val commentCnt: Int, // 1
            @SerializedName("flag") val flag: Int // 0
    ) {

        /*data class Comment(
                @SerializedName("comment_idx") val commentIdx: Int, // 46
                @SerializedName("comment_desc") val commentDesc: String, // 구경구경
                @SerializedName("comment_date") val commentDate: String, // 2018-07-08T09:05:49.000Z
                @SerializedName("comment_id") val commentId: String // joon_89
        )*/
    }
}