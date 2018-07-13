package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class PostBoardModel(
        @SerializedName("message") val message: String, // Successfully register
        @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531478781535.png
        @SerializedName("board_idx") val boardIdx: Int, // 56
        @SerializedName("board_auth") val boardAuth: String, // PUBLIC
        @SerializedName("board_stylelist") val boardStylelist: List<String>
)