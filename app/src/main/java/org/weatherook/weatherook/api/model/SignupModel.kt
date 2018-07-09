package org.weatherook.weatherook.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SignupModel {

    @SerializedName("user_id")
    @Expose
    lateinit var user_id: String

    @SerializedName("user_pw")
    @Expose
    lateinit var user_pw: String

    @SerializedName("user_gender")
    @Expose
    lateinit var user_gender: String

    @SerializedName("user_age")
    @Expose
    var user_age:Int = 20

    @SerializedName("user_height")
    @Expose
    var user_height: Int = 170

    @SerializedName("user_weight")
    @Expose
    var user_weight: Int = 50

    @SerializedName("user_gender")
    @Expose
    lateinit var user_stylelist: String
}