package org.weatherook.weatherook.item

data class UserSettingUpdateData (
        val user_desc : String,
        val user_gender : String,
        val user_age : Int,
        val user_img : String,
        val user_height : Int,
        val user_weight : Int,
        val user_stylelist : ArrayList<String>
)