package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject
import org.weatherook.weatherook.item.LatLongItem

object LatLongDriver {
    val LatLongDriver: BehaviorSubject<LatLongItem> = BehaviorSubject.create()
}