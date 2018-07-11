package org.weatherook.weatherook.item

/**
 * Created by HYEON on 2018-07-04.
 */

data class MyListRecyclerviewData(
        var user_img: String,
        var user_id: String,
        var user_desc: String,
        var board_img: String,
        var board_desc: String,
        var board_date: String,
        var board_weather: Int,
        var board_temp_min: Int,
        var board_temp_max: Int
)