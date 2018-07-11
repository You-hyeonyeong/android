package org.weatherook.weatherook.item

import com.google.gson.annotations.SerializedName

data class BoardCommentItem(
        @SerializedName("comment_idx") val commentIdx: Int, // 46
        @SerializedName("comment_desc") val commentDesc: String, // 구경구경
        @SerializedName("comment_date") val commentDate: String, // 2018-07-08T09:05:49.000Z
        @SerializedName("comment_id") val commentId: String // joon_89
)