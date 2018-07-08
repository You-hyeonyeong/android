package org.weatherook.weatherook.singleton

import android.view.View
import io.reactivex.subjects.BehaviorSubject

object ViewDriver {
    val viewDriver: BehaviorSubject<View> = BehaviorSubject.create()
}