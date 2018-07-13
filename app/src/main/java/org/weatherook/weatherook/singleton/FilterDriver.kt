package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject
import org.weatherook.weatherook.item.FilterItem

object FilterDriver {
    val LatLongDriver: BehaviorSubject<FilterItem> = BehaviorSubject.create()
}