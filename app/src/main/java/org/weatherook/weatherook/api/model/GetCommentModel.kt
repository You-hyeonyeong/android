package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class GetCommentModel(
        @SerializedName("message") val message: String, // Successfully get comment list
        @SerializedName("data") val data: List<Data>,
        @SerializedName("user_img") val userImg: String // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531433783608.jpeg
) {

    data class Data(
            @SerializedName("comment_idx") val commentIdx: Int, // 92
            @SerializedName("comment_desc") val commentDesc: String, // 사진 잘 나왔다 ㅎ
            @SerializedName("comment_date") val commentDate: String, // 2018-07-10T22:41:38.000Z
            @SerializedName("comment_id") val commentId: String, // may_15
            @SerializedName("user_img") val userImg: String // https://s3.ap-northeast-2.amazonaws.com/weatherook/jonghyun.jpeg
    )
}