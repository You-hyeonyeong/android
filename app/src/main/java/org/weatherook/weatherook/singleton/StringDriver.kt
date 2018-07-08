package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject

object StringDriver {
    val stringDriver: BehaviorSubject<String> = BehaviorSubject.create()
}