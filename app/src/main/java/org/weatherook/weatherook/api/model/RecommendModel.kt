package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName


data class RecommendModel(
        @SerializedName("message") val message: String, // Successfully get today fashion list
        @SerializedName("data") val data: List<Data>
) {

    data class Data(
            @SerializedName("commend_idx") val commendIdx: Int, // 20
            @SerializedName("commend_img") val commendImg: String, // https://s3.ap-northeast-2.amazonaws.com/weatherook/24+%ED%81%B4%EB%9E%98%EC%8B%9D.JPG
            @SerializedName("commend_ref") val commendRef: Any // null
    )
}