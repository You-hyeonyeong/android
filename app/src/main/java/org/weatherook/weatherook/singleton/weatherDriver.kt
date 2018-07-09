package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject

object weatherDriver {
    val weatherDriver: BehaviorSubject<String> = BehaviorSubject.create()
}