package org.weatherook.weatherook.singleton

import io.reactivex.subjects.BehaviorSubject
import org.weatherook.weatherook.api.model.SignupModel

object tokenDriver {
    val tokenDriver: BehaviorSubject<String> = BehaviorSubject.create()
}