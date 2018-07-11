package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName

data class SignupModel(
        @SerializedName("user_id") internal var userId: String,
        @SerializedName("user_pw") internal var userPw: String,
        @SerializedName("user_gender") internal var userGender: String,
        @SerializedName("user_age") internal var userAge: Int,
        @SerializedName("user_height") internal var userHeight: Int,
        @SerializedName("user_weight") internal var userWeight: Int,
        @SerializedName("user_stylelist") internal var userStylelist: ArrayList<String>
)
