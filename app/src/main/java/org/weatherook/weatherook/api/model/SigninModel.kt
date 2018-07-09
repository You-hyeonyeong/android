package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName

data class SigninModel(@field:SerializedName("user_id")
           internal var mId: String, @field:SerializedName("user_pw")
           internal var mName: String)

