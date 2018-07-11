package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class BellModel(
        @SerializedName("message") val message: String, // success my news
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("flag") val flag: Int, // 1
            @SerializedName("comment_str") val commentStr: String, // 님이 댓글을 남겼습니다
            @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531061777961.PNG
            @SerializedName("board_idx") val boardIdx: Int, // 2
            @SerializedName("comment_idx") val commentIdx: Int, // 21
            @SerializedName("comment_img") val commentImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/sunny.jpeg
            @SerializedName("comment_desc") val commentDesc: String, // 사랑해
            @SerializedName("comment_id") val commentId: String, // dozen_k
            @SerializedName("date") val date: String, // 0000-00-00 00:00:00
            @SerializedName("date_modify") val dateModify: String, // Invalid date
            @SerializedName("follow_str") val followStr: String, // 님이 회원님을 팔로우 했습니다.
            @SerializedName("follow") val follow: String, // joon_89
            @SerializedName("follow_img") val followImg: String // https://s3.ap-northeast-2.amazonaws.com/weatherook/youngjun.jpeg
    )
}