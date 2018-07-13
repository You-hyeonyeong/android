package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject
import org.weatherook.weatherook.item.FilterItem

object FilterDriver {
    val filterDriver: BehaviorSubject<FilterItem> = BehaviorSubject.create()
}