package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject

object Driver {
    val galleryDriver: BehaviorSubject<String> = BehaviorSubject.create()
}