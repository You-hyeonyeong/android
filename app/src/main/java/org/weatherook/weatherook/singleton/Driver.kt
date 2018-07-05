package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject

object Driver {
    val gallayDriver: BehaviorSubject<String> = BehaviorSubject.create()
}