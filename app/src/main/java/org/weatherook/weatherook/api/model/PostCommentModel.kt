package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class PostCommentModel(
        @SerializedName("message") val message: String, // Successfully register comment
        @SerializedName("comment_idx") val commentIdx: Int, // 147
        @SerializedName("board_idx") val boardIdx: String, // 1
        @SerializedName("comment_desc") val commentDesc: String // dididi
)