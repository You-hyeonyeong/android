package org.weatherook.weatherook.api.model

import com.google.gson.annotations.SerializedName

data class SigninModel(@SerializedName("message") val message: String, // Successfully sign in
                       @SerializedName("token") val token: String)

