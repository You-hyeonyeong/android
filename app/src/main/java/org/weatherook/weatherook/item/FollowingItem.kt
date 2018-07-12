package org.weatherook.weatherook.item

import org.weatherook.weatherook.api.model.BoardCommentModel

data class FollowingItem (
        var boardIdx : Int,
        var profile : String,
        var id : String,
        //var heart : Int,
        var count : Int,
        var photo : String,
        var date : String,
        var weather : Int,
        var temperature : String,
        var content : String,
        var comment : List<BoardCommentItem>
)