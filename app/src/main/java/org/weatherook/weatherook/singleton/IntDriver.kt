package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject

object IntDriver {
    val intDriver: BehaviorSubject<Int> = BehaviorSubject.create()
}