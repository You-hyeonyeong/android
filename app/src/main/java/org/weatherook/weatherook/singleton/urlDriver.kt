package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject

object urlDriver {
    val urlDriver: BehaviorSubject<String> = BehaviorSubject.create()
}