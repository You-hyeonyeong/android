package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject
import org.weatherook.weatherook.item.WeatherDriverItem

object WeatherDriver {
    val weatherDriver: BehaviorSubject<WeatherDriverItem> = BehaviorSubject.create()
}