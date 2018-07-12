package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName
import org.weatherook.weatherook.item.BoardCommentItem


data class PopularBoardModel(
        @SerializedName("message") val message: String, // Successfully today popular
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("board_idx") val boardIdx: Int, // 10
            @SerializedName("user_img") val userImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/sunny.jpeg
            @SerializedName("user_id") val userId: String, // dozen_k
            @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531062552007.PNG
            @SerializedName("board_desc") val boardDesc: String, // 날씨 너무 습하다 기절할뻔
            @SerializedName("like_cnt") val likeCnt: Int, // 1
            @SerializedName("board_temp_min") val boardTempMin: Int, // 14
            @SerializedName("board_temp_max") val boardTempMax: Int, // 20
            @SerializedName("board_weather") val boardWeather: Int, // 4
            @SerializedName("board_date") val boardDate: String, // 07-01
            @SerializedName("comment_list") val commentList: List<BoardCommentItem>,
            @SerializedName("comment_cnt") val commentCnt: Int, // 3
            @SerializedName("flag") val flag: Int // 1
    ) {

        /*data class Comment(
                @SerializedName("comment_idx") val commentIdx: Int, // 43
                @SerializedName("comment_desc") val commentDesc: String, // 친하게지내요
                @SerializedName("comment_date") val commentDate: String, // 2018-07-08T09:05:00.000Z
                @SerializedName("comment_id") val commentId: String // joon_89
        )*/
    }
}