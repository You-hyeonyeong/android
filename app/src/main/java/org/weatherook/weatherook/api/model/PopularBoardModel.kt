package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName
import org.weatherook.weatherook.item.BoardCommentItem


data class PopularBoardModel(
        @SerializedName("message") val message: String, // Successfully today popular
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("board_idx") val boardIdx: Int, // 19
            @SerializedName("user_img") val userImg: String?, // https://s3.ap-northeast-2.amazonaws.com/weatherook/hyunyoung.jpeg
            @SerializedName("user_id") val userId: String, // graycode
            @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531063432130.PNG
            @SerializedName("board_desc") val boardDesc: String?, // 열일!!♥~~
            @SerializedName("like_cnt") val likeCnt: Int, // 0
            @SerializedName("board_temp_min") val boardTempMin: Int, // 18
            @SerializedName("board_temp_max") val boardTempMax: Int, // 29
            @SerializedName("board_weather") val boardWeather: Int, // 0
            @SerializedName("board_date") val boardDate: String, // 07-01
            @SerializedName("comment_list") val commentList: List<BoardCommentItem>,
            @SerializedName("comment_cnt") val commentCnt: Int, // 2
            @SerializedName("flag") val flag: Int // 0
    ) {

        /*data class Comment(
                @SerializedName("comment_idx") val commentIdx: Int, // 62
                @SerializedName("comment_desc") val commentDesc: String, // 오우쉣
                @SerializedName("comment_date") val commentDate: String, // 2018-07-08T09:18:23.000Z
                @SerializedName("comment_id") val commentId: String // mina_3
        )*/
    }
}