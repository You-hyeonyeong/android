package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class BellModel(
        @SerializedName("message") val message: String, // success my news
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("flag") val flag: Int, // 1
            @SerializedName("comment_str") val commentStr: String, // 님이 댓글을 남겼습니다
            @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531061851244.PNG
            @SerializedName("board_idx") val boardIdx: Int, // 3
            @SerializedName("comment_idx") val commentIdx: Int, // 24
            @SerializedName("comment_img") val commentImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA+2018-07-11+%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE+10.36.06.png
            @SerializedName("comment_desc") val commentDesc: String, // 좋은 하루 보내세요!
            @SerializedName("comment_id") val commentId: String, // drifin94
            @SerializedName("date") val date: String, // Invalid date
            @SerializedName("date_modify") val dateModify: String, // Invalid date
            @SerializedName("follow_str") val followStr: String, // 님이 회원님을 팔로우 했습니다.
            @SerializedName("follow") val follow: String, // minkyoe
            @SerializedName("follow_img") val followImg: Any // null
    )
}