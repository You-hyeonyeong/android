package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class MyBoardModel(
        @SerializedName("message") val message: String, // Successfully total board filtering
        @SerializedName("showUserPageResult") val showUserPageResult: List<ShowUserPageResult>,
        @SerializedName("showBoardNumResult") val showBoardNumResult: List<ShowBoardNumResult>,
        @SerializedName("showFollowerNumResult") val showFollowerNumResult: List<ShowFollowerNumResult>,
        @SerializedName("showFollowingNumResult") val showFollowingNumResult: List<ShowFollowingNumResult>,
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("user_img") val userImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/jonghyun.jpeg
            @SerializedName("user_id") val userId: String, // awesome33
            @SerializedName("board_idx") val boardIdx: Int, // 3
            @SerializedName("board_img") val boardImg: String, // https://weatherook.s3.ap-northeast-2.amazonaws.com/1531061851244.PNG
            @SerializedName("board_desc") val boardDesc: String, // 날씨가 좋아져서 다행이다
            @SerializedName("like_cnt") val likeCnt: Int, // 1
            @SerializedName("board_temp_min") val boardTempMin: Int, // 15
            @SerializedName("board_temp_max") val boardTempMax: Int, // 22
            @SerializedName("board_weather") val boardWeather: Int, // 2
            @SerializedName("board_date") val boardDate: String, // 07-07
            @SerializedName("comment_list") val commentList: List<Comment>,
            @SerializedName("comment_cnt") val commentCnt: Int, // 3
            @SerializedName("flag") val flag: Int // 1
    ) {

        data class Comment(
                @SerializedName("comment_idx") val commentIdx: Int, // 45
                @SerializedName("comment_desc") val commentDesc: String, // 굿!
                @SerializedName("comment_date") val commentDate: String, // 2018-07-08T09:05:31.000Z
                @SerializedName("comment_id") val commentId: String // joon_89
        )
    }


    data class ShowFollowerNumResult(
            @SerializedName("follower") val follower: Int // 6
    )


    data class ShowBoardNumResult(
            @SerializedName("board_num") val boardNum: Int // 3
    )


    data class ShowUserPageResult(
            @SerializedName("user_img") val userImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/jonghyun.jpeg
            @SerializedName("user_id") val userId: String, // awesome33
            @SerializedName("user_desc") val userDesc: String // 안녕!
    )


    data class ShowFollowingNumResult(
            @SerializedName("following") val following: Int // 9
    )
}